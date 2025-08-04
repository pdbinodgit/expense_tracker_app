package com.expense_tracker_app.expense_tracker_app.userinformation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserInformationDto {

    private Long id;

    @NotBlank(message = "First name is required.")
    private String  firstName;

    private String middleName;

    @NotBlank(message = "Middle name is required.")
    private String lastName;

    private Long age;
    @NotBlank(message = "Date of birth is required.")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Password is required.")
    private String password;

    private LocalDateTime createdAt;

    private String createdBy;
}
