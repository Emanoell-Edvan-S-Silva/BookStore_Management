package br.com.base.authentication.DTOs;

import br.com.base.shared.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

@Builder
@Schema(name = "LoginResponse")
public record LoginResponseDTO(
        @Schema(description = "Token", example = "ekJhbGciZiJIUzI1niJ4")
        String token,
        @Schema(description = "Nickname", example = "Nickname")
        String nickname,
        @Schema(description = "Permissions", example = "[\"WRITE\"]")
        List<Roles> roles
) implements Serializable {
}
