package com.expense_tracker_app.expense_tracker_app.role.serviceImpl;

import com.expense_tracker_app.expense_tracker_app.customexception.TrackerException;
import com.expense_tracker_app.expense_tracker_app.mapper.RoleMapper;
import com.expense_tracker_app.expense_tracker_app.role.dto.RoleDto;
import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import com.expense_tracker_app.expense_tracker_app.role.repository.RoleRepository;
import com.expense_tracker_app.expense_tracker_app.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public RoleDto save(RoleDto roleDto) {
        Optional<Role> optionalRole=roleRepository.findByRoleName(roleDto.getRoleName());
        if (optionalRole.isPresent()){
            throw  new TrackerException("Role name already present.", HttpStatus.BAD_REQUEST,400);
        }
        Role role=roleRepository.save(roleMapper.dtoToEntity(roleDto));
        return roleMapper.entityToDto(role);
    }

    @Override
    public List<RoleDto> findAllRole() {
        List<Role> roleList=roleRepository.findAll();
        List<RoleDto> roleDtoList=roleList.stream().map(role -> roleMapper.entityToDto(role)).toList();
        return roleDtoList;
    }
}
