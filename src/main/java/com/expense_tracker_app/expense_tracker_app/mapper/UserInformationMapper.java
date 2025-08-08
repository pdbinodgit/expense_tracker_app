package com.expense_tracker_app.expense_tracker_app.mapper;

import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = RoleMapper.class)
public interface UserInformationMapper {
    @Mapping(source = "rolesDto", target = "roles")
    public UserInformation dtoToEntity(UserInformationDto dto);
    @Mapping(source = "roles", target = "rolesDto")
    public UserInformationDto entityToDto(UserInformation userInformation);
}
