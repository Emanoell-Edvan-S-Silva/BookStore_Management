package br.com.base.authentication.services.impl;

import br.com.base.authentication.entities.RoleEntity;
import br.com.base.authentication.repositories.RoleRepository;
import br.com.base.authentication.services.RoleService;
import br.com.base.shared.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleEntity getById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new EntityNotFoundException("Role.InvalidData.NotFound"));
    }

    @Override
    public List<RoleEntity> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<RoleEntity> getAllByIds(Set<Long> roleIds) {
        return roleIds.stream().map(this::getById).toList();
    }

}