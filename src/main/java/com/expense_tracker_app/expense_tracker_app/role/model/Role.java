package com.expense_tracker_app.expense_tracker_app.role.model;

import com.expense_tracker_app.expense_tracker_app.role.roleenum.RoleEnum;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleEnum roleName;

}
