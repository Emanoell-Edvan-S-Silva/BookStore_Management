package br.com.base.authentication.services;

import br.com.base.authentication.DTOs.LoginRequestDTO;
import br.com.base.authentication.DTOs.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO auth(LoginRequestDTO request);
}
