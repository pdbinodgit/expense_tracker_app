package com.expense_tracker_app.expense_tracker_app.role.dto;

import com.expense_tracker_app.expense_tracker_app.role.roleenum.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private Long id;

    private RoleEnum roleName;
}
