package com.expense_tracker_app.expense_tracker_app.role.controller;

import com.expense_tracker_app.expense_tracker_app.customresponse.ApiResponse;
import com.expense_tracker_app.expense_tracker_app.role.dto.RoleDto;
import com.expense_tracker_app.expense_tracker_app.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse<?>> saveRole(@RequestBody RoleDto roleDto){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(HttpStatus.OK,"Role save successfully",roleService.save(roleDto)));
    }
}
