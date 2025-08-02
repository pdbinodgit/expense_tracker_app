package com.expense_tracker_app.expense_tracker_app.userinformation.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserInformationDto {

    private Long id;

    private String  firstName;

    private String middleName;

    private String lastName;

    private Long age;

    private LocalDate dateOfBirth;

    private String username;

    private String password;

    private LocalDateTime createdAt;

    private String createdBy;
}
