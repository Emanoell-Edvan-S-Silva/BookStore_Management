package br.com.base.authentication.configurations;

import br.com.base.shared.DTOs.ProblemDTO;
import br.com.base.shared.enums.ProblemType;
import br.com.base.shared.utils.DateTimeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;

    public AccessDeniedHandlerImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        int status = HttpStatus.FORBIDDEN.value();

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status);

        OutputStream out = response.getOutputStream();
        objectMapper.writeValue(out, buildProblem(status));
        out.flush();
    }

    private ProblemDTO buildProblem(int status) {
        String detail = "UserDontHavePermission";
        return ProblemDTO.builder()
                .status(status)
                .timestamp(DateTimeUtil.nowZoneUTC())
                .type(ProblemType.ACCESS_DENIED.getUri())
                .title(ProblemType.ACCESS_DENIED.getTitle())
                .detail(detail)
                .userMessage(detail)
                .build();
    }
}
