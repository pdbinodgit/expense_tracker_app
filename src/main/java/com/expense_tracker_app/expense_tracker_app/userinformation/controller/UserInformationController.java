package com.expense_tracker_app.expense_tracker_app.userinformation.controller;

import com.expense_tracker_app.expense_tracker_app.customresponse.ApiResponse;
import com.expense_tracker_app.expense_tracker_app.userinformation.dto.UserInformationDto;
import com.expense_tracker_app.expense_tracker_app.userinformation.service.UserInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInformationController {

    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveuser(@RequestBody @Valid UserInformationDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"User information saved successfully",userInformationService.saveUserInformation(dto)));
    }
}
