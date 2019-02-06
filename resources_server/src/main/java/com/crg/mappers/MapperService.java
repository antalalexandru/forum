package com.crg.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperService {
    @Bean
    public UserMapper getUserMapper() {
        return new UserMapper();
    }
}
