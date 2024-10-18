package br.com.base.shared.utils;

import br.com.base.authentication.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUtil {

    public static UserEntity getUser() {
        return (UserEntity) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
}
