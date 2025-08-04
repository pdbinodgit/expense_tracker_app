package com.expense_tracker_app.expense_tracker_app.userinformation.serviceImpl;

import com.expense_tracker_app.expense_tracker_app.customexception.TrackerException;
import com.expense_tracker_app.expense_tracker_app.mapper.UserInformationMapper;
import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import com.expense_tracker_app.expense_tracker_app.userinformation.repository.UserInformationRepository;
import com.expense_tracker_app.expense_tracker_app.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInformationServiceImpl implements UserInformationService {
    @Autowired
    UserInformationRepository userInformationRepository;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Override
    public UserInformationDto saveUserInformation(UserInformationDto userInformationDto) {

        Optional<UserInformation> userInformationOptional=userInformationRepository.findByUsername(userInformationDto.getUsername());
        if (userInformationOptional.isPresent()){
            throw  new TrackerException("Username already present", HttpStatus.BAD_REQUEST,400);
        }
        UserInformation user = userInformationRepository.save(userInformationMapper.dtoToEntity(userInformationDto));
        return userInformationMapper.entityToDto(user);
    }
}
