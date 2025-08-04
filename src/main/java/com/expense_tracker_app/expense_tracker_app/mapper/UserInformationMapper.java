package com.expense_tracker_app.expense_tracker_app.mapper;

import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInformationMapper {
    public UserInformation dtoToEntity(UserInformationDto dto);

    public UserInformationDto entityToDto(UserInformation userInformation);
}
