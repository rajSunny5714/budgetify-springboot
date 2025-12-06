package com.budgetify.Services;

import com.budgetify.Data.IExpenseRepository;
import com.budgetify.Interfaces.IExpenseService;
import com.budgetify.Models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExpenseService implements IExpenseService {

    private final IExpenseRepository repository;

    public ExpenseService(IExpenseRepository repo) {
        this.repository = repo;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense addNewExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public String RemoveExpense(Integer id) {
        repository.deleteById(id);
        return "Expense removed";
    }

    @Override
    public Expense UpdateExpense(Expense expense) {
        Optional<Expense> currentExpense = repository.findById(expense.getId());
        if(currentExpense.isPresent()){
            Expense fetchedExpense = currentExpense.get();
            fetchedExpense.setName(expense.getName());
            fetchedExpense.setCategory(expense.getCategory());
            fetchedExpense.setAmount(expense.getAmount());
            return repository.save(fetchedExpense);
        }
        throw new RuntimeException("Expense not found");
    }

    // ✅ CLEAR ALL METHOD
    @Override
    public void clearAllExpenses() {
        repository.deleteAll();
    }
}