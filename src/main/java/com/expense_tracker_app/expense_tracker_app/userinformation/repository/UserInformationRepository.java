package com.expense_tracker_app.expense_tracker_app.userinformation.repository;

import com.expense_tracker_app.expense_tracker_app.userinformation.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation,Long> {
}
