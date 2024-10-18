package br.com.base.authentication.annotations;

import br.com.base.shared.annotations.OpenApiResponse200;
import br.com.base.shared.annotations.OpenApiResponse401;
import br.com.base.shared.annotations.OpenApiResponse403;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Operation(
        summary = "Get all roles",
        description = "Requires permission: "
)
//@PreAuthorize("")
@RequestMapping(method = RequestMethod.GET, produces = "application/json")
@OpenApiResponse200
@OpenApiResponse401
@OpenApiResponse403
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GetAllPermissionsEndpoint {
}
