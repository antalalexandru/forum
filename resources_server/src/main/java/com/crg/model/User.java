package com.crg.model;

import com.crg.annotation.ValidEmail;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonView(Views.Public.class)
    private Integer id;

    @JsonView(Views.Public.class)
    private String username;

    @JsonView(Views.AdminOnly.class)
    @ValidEmail
    private String email;

    @JsonView(Views.AdminOnly.class)
    private String password;

    @JsonView(Views.Public.class)
    private Boolean accountActivated;
}