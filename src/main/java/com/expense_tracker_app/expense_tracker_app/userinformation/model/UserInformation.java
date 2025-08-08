package com.expense_tracker_app.expense_tracker_app.userinformation.model;

import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_role",
    joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
