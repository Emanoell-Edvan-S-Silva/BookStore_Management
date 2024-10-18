package br.com.base.authentication.services;

import br.com.base.authentication.entities.UserEntity;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserEntity getById(Long userId);

    List<UserEntity> getAllByIds(Set<Long> userIds);
}