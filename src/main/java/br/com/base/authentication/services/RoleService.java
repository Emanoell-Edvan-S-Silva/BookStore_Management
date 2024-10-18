package br.com.base.authentication.services;

import br.com.base.authentication.entities.RoleEntity;

import java.util.List;
import java.util.Set;

public interface RoleService {

    RoleEntity getById(Long roleId);

    List<RoleEntity> getAll();

    List<RoleEntity> getAllByIds(Set<Long> roleIds);
}
