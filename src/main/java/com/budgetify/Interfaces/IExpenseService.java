package com.budgetify.Interfaces;

import com.budgetify.Models.Expense;
import java.util.List;

public interface IExpenseService {
    List<Expense> getAllExpenses();
    Expense addNewExpense(Expense expense);
    String RemoveExpense(Integer id);
    Expense UpdateExpense(Expense expense);

    // ✅ Add this
    void clearAllExpenses();
}
