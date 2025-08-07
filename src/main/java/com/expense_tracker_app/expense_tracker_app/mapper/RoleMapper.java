package com.expense_tracker_app.expense_tracker_app.mapper;

import com.expense_tracker_app.expense_tracker_app.role.dto.RoleDto;
import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    public RoleDto entityToDto(Role role);
    public RoleDto dtoToEntity(RoleDto dto);
}
