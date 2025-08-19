package com.expense_tracker_app.expense_tracker_app.income.repository;

import com.expense_tracker_app.expense_tracker_app.income.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {
}
