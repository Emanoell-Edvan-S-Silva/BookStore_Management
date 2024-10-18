package br.com.base.authentication.services.impl;

import br.com.base.authentication.DTOs.LoginRequestDTO;
import br.com.base.authentication.DTOs.LoginResponseDTO;
import br.com.base.authentication.entities.UserEntity;
import br.com.base.authentication.services.AuthService;
import br.com.base.authentication.services.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    public LoginResponseDTO auth(LoginRequestDTO request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var user = (UserEntity) auth.getPrincipal();
        var token = tokenService.generate(user);
        return buildLoginResponseDTO(token, user);
    }

    private LoginResponseDTO buildLoginResponseDTO(String token, UserEntity user) {
        return LoginResponseDTO.builder()
                .token(token)
                .nickname(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
}