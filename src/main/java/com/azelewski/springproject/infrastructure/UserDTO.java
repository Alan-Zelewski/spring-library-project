package com.azelewski.springproject.infrastructure;

import com.azelewski.springproject.validation.PasswordMatches;
import com.azelewski.springproject.validation.ValidEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordMatches
public class UserDTO {
    @NotNull(message = "is required.")
    @NotEmpty
    private String firstName;
    @NotNull(message = "is required.")
    @NotEmpty
    private String lastName;
    @NotNull(message = "is required.")
    @NotEmpty
    @ValidEmail(message = "invalid")
    private String email;
    @NotNull(message = "is required.")
    @NotEmpty
    private String username;
    @NotNull(message = "is required.")
    @NotEmpty
    private String password;
    @NotNull(message = "is required.")
    @NotEmpty
    private String matchingPassword;
}
