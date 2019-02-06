package com.crg.controller;

import com.crg.model.User;
import com.crg.model.Views;
import com.crg.model.dto.UserDto;
import com.crg.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/member")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @JsonView(Views.Public.class)
    @ApiOperation(value="Add a new user", response = User.class, code = 201)
    @ApiResponses({
            @ApiResponse(code = 201, message = "User was successfully added"),
            @ApiResponse(code = 409, message = "Username or email already exists"),
            @ApiResponse(code = 422, message = "Invalid user data")
    })
    public User createUser(@RequestBody @Valid UserDto user) {
        return userService.addUser(user);
    }
}
