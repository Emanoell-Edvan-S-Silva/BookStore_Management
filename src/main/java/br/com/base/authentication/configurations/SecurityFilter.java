package br.com.base.authentication.configurations;

import br.com.base.authentication.repositories.UserRepository;
import br.com.base.authentication.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        var token = tokenService.extractToken(request);
        if (token.isPresent()) {
            if (tokenService.isValid(token.get())) {
                authenticate(token.get());
            }
        }
        filterChain.doFilter(request, response);
    }

    private void authenticate(String token) {
        var username = tokenService.extractUsername(token);
        if (username.isPresent()) {
            var loggedUser = userRepository.findByName(username.get());
            if (loggedUser.isPresent()) {
                var user = loggedUser.get();
                var authorities = tokenService.extractRoles(token);
                var authentication = new UsernamePasswordAuthenticationToken(username.get(), user.getId(), authorities);
                authentication.setDetails(user);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
    }
}