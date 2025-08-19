package com.expense_tracker_app.expense_tracker_app.income.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class IncomeDto {

    private Long id;

    private BigDecimal amount;

    private String remark;
}
