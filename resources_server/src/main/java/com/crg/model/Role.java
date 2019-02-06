package com.crg.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    private int id;
    private String role_name;
}