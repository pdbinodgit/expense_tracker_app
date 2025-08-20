package com.expense_tracker_app.expense_tracker_app.mapper;

import com.expense_tracker_app.expense_tracker_app.income.dto.IncomeDto;
import com.expense_tracker_app.expense_tracker_app.income.model.Income;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    public Income dtoToEntity(IncomeDto dto);

    public IncomeDto entityToDto(Income income);

}
