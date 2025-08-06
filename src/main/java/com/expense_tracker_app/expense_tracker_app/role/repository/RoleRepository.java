package com.expense_tracker_app.expense_tracker_app.role.repository;

import com.expense_tracker_app.expense_tracker_app.role.model.Role;
import com.expense_tracker_app.expense_tracker_app.role.roleenum.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(RoleEnum role);
}
