package com.expense_tracker_app.expense_tracker_app.role.service;

import com.expense_tracker_app.expense_tracker_app.role.dto.RoleDto;

import java.util.List;

public interface RoleService {
    public RoleDto save(RoleDto roleDto);
    public List<RoleDto> findAllRole();
}
