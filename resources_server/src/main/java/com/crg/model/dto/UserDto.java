package com.crg.model.dto;

import com.crg.annotation.ValidPlainTextPassword;
import com.crg.annotation.ValidEmail;
import com.crg.annotation.ValidUsername;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    @ValidUsername
    private String username;

    @ValidEmail
    private String email;

    @ValidPlainTextPassword
    private String plainTextPassword;
}
