package br.com.base.authentication.mappers;

import br.com.base.authentication.DTOs.GetRolesResponseDTO;
import br.com.base.authentication.entities.RoleEntity;
import br.com.base.shared.enums.RoleType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    public List<GetRolesResponseDTO> toGetRolesResponseDTO(List<RoleEntity> roles) {
        var response = new ArrayList<GetRolesResponseDTO>();
        List.of(RoleType.values()).forEach(roleType -> {
            var filteredRoles = roles.stream().filter(role -> role.getType().equals(roleType)).toList();
            response.add(GetRolesResponseDTO.builder().type(roleType).roles(getRoleDTOs(filteredRoles)).build());
        });
        return response;

    }

    private List<GetRolesResponseDTO.RoleDTO> getRoleDTOs(List<RoleEntity> roles) {
        return roles.stream().map(role -> GetRolesResponseDTO.RoleDTO.builder()
                .id(role.getId())
                .name(role.getName().name())
                .build()).toList();
    }
}