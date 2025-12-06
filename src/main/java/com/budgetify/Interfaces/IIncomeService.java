package com.budgetify.Interfaces;

import com.budgetify.Models.Income;
import java.util.List;

public interface IIncomeService {
    List<Income> getAllIncomeSources();
    Income addNewIncomeSource(Income income);
    String RemoveIncomeSource(Integer id);
    Income UpdateIncomeSource(Income income);
    void clearAllIncome();
}