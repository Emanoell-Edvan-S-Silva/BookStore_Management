package br.com.base.authentication.services.impl;

import br.com.base.authentication.entities.UserEntity;
import br.com.base.authentication.repositories.UserRepository;
import br.com.base.authentication.services.UserService;
import br.com.base.shared.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User.InvalidData.NotFound"));
    }

    @Override
    public List<UserEntity> getAllByIds(Set<Long> userIds) {
        return userIds.stream().map(this::getById).toList();
    }
}