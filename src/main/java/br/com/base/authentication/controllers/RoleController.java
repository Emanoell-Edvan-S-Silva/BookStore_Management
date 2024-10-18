package br.com.base.authentication.controllers;

import br.com.base.authentication.DTOs.GetRolesResponseDTO;
import br.com.base.authentication.annotations.GetAllPermissionsEndpoint;
import br.com.base.authentication.mappers.RoleMapper;
import br.com.base.authentication.services.RoleService;
import br.com.base.shared.annotations.ApiController;
import br.com.base.shared.annotations.OpenApiController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@OpenApiController(name = "Role")
@ApiController(path = "/v1/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @GetAllPermissionsEndpoint
    public ResponseEntity<List<GetRolesResponseDTO>> getAll() {
        var roles = roleService.getAll();
        return new ResponseEntity<>(roleMapper.toGetRolesResponseDTO(roles), HttpStatus.OK);
    }
}