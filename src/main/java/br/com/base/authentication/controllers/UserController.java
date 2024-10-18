package br.com.base.authentication.controllers;

import br.com.base.authentication.services.UserService;
import br.com.base.shared.annotations.ApiController;
import br.com.base.shared.annotations.OpenApiController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@OpenApiController(name = "User")
@ApiController(path = "/v1/users")
public class UserController {

    private final UserService userService;

}