package br.com.base.authentication.controllers;

import br.com.base.authentication.DTOs.LoginRequestDTO;
import br.com.base.authentication.DTOs.LoginResponseDTO;
import br.com.base.authentication.annotations.LoginEndpoint;
import br.com.base.authentication.services.AuthService;
import br.com.base.shared.annotations.ApiController;
import br.com.base.shared.annotations.OpenApiController;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@OpenApiController(name = "Authentication")
@ApiController(path = "/v1/auth")
public class AuthController {

    private final AuthService authService;

    @LoginEndpoint
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        var response = authService.auth(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}