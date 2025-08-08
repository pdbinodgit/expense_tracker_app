package com.expense_tracker_app.expense_tracker_app.userinformation.serviceImpl;

import com.expense_tracker_app.expense_tracker_app.customexception.TrackerException;
import com.expense_tracker_app.expense_tracker_app.mapper.UserInformationMapper;
import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import com.expense_tracker_app.expense_tracker_app.userinformation.repository.UserInformationRepository;
import com.expense_tracker_app.expense_tracker_app.userinformation.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
            throw new TrackerException("Username already present", HttpStatus.BAD_REQUEST,400);
        }
        userInformationDto.setCreatedAt(LocalDateTime.now());
        UserInformation userInformation=userInformationMapper.dtoToEntity(userInformationDto);


        UserInformation user = userInformationRepository.save(userInformationMapper.dtoToEntity(userInformationDto));
        return userInformationMapper.entityToDto(user);
    }

    @Override
    public List<UserInformationDto> findAllUserInformation() {
        List<UserInformation> userInformations=userInformationRepository.findAll();
        List<UserInformationDto> dtos=userInformations.stream().
                map(userInformation -> userInformationMapper.entityToDto(userInformation)).toList();
        return dtos;
    }

    @Override
    public UserInformationDto findUserInformationById(long id) {
        Optional<UserInformation> userInformationOptional=userInformationRepository.findById(id);
        if (!userInformationOptional.isPresent()){
            throw new TrackerException("User not found",HttpStatus.BAD_REQUEST,400);
        }

        return userInformationMapper.entityToDto(userInformationOptional.get());
    }


}
