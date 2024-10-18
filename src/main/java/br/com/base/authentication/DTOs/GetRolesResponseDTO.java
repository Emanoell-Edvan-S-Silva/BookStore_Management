package br.com.base.authentication.DTOs;

import br.com.base.shared.enums.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
@Schema(name = "GetRolesResponse")
public record GetRolesResponseDTO(
        @Schema(description = "Type", example = "PROFILE") RoleType type,
        @Schema(description = "Role") List<RoleDTO> roles) {
    @Builder
    public record RoleDTO(
            @Schema(description = "Id", example = "7") Long id,
            @Schema(description = "Name", example = "CREATE_PROFILE") String name) {
    }
}
