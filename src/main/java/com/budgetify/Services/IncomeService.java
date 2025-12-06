package com.budgetify.Services;

import com.budgetify.Data.IIncomeRepository;
import com.budgetify.Interfaces.IIncomeService;
import com.budgetify.Models.Income;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService implements IIncomeService {

    private final IIncomeRepository repository;

    public IncomeService(IIncomeRepository repo) {
        this.repository = repo;
    }

    @Override
    public List<Income> getAllIncomeSources() {
        return repository.findAll();
    }

    @Override
    public Income addNewIncomeSource(Income incomeSource) {
        return repository.save(incomeSource);
    }

    @Override
    public String RemoveIncomeSource(Integer id) {
        repository.deleteById(id);
        return "Income removed";
    }

    @Override
    public Income UpdateIncomeSource(Income income) {
        Optional<Income> currentIncome = repository.findById(income.getId());
        if (currentIncome.isPresent()) {
            Income fetchedIncome = currentIncome.get();
            fetchedIncome.setName(income.getName());
            fetchedIncome.setCategory(income.getCategory());
            fetchedIncome.setAmount(income.getAmount());
            fetchedIncome.setDate(income.getDate());
            return repository.save(fetchedIncome);
        }
        throw new RuntimeException("Income not found");
    }

    @Override
    public void clearAllIncome() {
        repository.deleteAll();
    }
}