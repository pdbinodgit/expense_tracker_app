package com.expense_tracker_app.expense_tracker_app.userinformation.service;

import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;

import java.util.List;

public interface UserInformationService {

    public UserInformationDto saveUserInformation(UserInformationDto userInformationDto);

    public List<UserInformationDto> findAllUserInformation();
    public UserInformationDto findUserInformationById();
}
