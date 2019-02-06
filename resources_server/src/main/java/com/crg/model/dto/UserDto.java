package com.crg.model.dto;

import lombok.*;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @NotNull
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9_\\-]+")
    @Size(min = 5, max = 30)
    private String username;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 5)
    @Pattern(regexp = ".*[a-z].*")
    @Pattern(regexp = ".*[A-Z].*")
    @Pattern(regexp = ".*[0-9].*")
    private String password;

}

/*

{
    "timestamp": "2019-02-07 01:58:51.264",
    "status": 422,
    "error": "Unprocessable entity",
    "message": "{userDto=com.crg.model.dto.UserDto@1d5f251e, org.springframework.validation.BindingResult.userDto=org.springframework.validation.BeanPropertyBindingResult: 1 errors\nField error in object 'userDto' on field 'password': rejected value [1234a]; codes [Pattern.userDto.password,Pattern.password,Pattern.java.lang.String,Pattern]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userDto.password,password]; arguments []; default message [password],[Ljavax.validation.constraints.Pattern$Flag;@29313c8,org.springframework.validation.beanvalidation.SpringValidatorAdapter$ResolvableAttribute@6f839aa1]; default message [must match \".*[A-Z].*\"]}"
}

* */