package com.dailycoder.security.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    private String email;

    // standard getters and setters


}
