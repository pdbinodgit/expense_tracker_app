package com.expense_tracker_app.expense_tracker_app.userinformation.serviceImpl;

import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.repository.UserInformationRepository;
import com.expense_tracker_app.expense_tracker_app.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationServiceImpl implements UserInformationService {
    @Autowired
    UserInformationRepository userInformationRepository;


    @Override
    public UserInformationDto saveUserInformation(UserInformationDto userInformationDto) {

        return null;
    }
}
