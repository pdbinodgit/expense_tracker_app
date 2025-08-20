package com.expense_tracker_app.expense_tracker_app.income.service;

import com.expense_tracker_app.expense_tracker_app.income.dto.IncomeDto;
import com.expense_tracker_app.expense_tracker_app.income.model.Income;

import java.util.List;

public interface IncomeService {

    public IncomeDto saveIncome(IncomeDto dto);

    public List<IncomeDto> findAllIncome();

}
