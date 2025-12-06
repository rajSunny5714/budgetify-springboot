package com.budgetify.Controllers;

import com.budgetify.Interfaces.IIncomeService;
import com.budgetify.Models.Income;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {

    private final IIncomeService incomeService;

    public IncomeController(IIncomeService inService) {
        this.incomeService = inService;
    }

    @GetMapping
    public List<Income> getIncomeList() {
        return incomeService.getAllIncomeSources();
    }

    @PostMapping("/addIncomeSource")
    public Income addIncome(@RequestBody Income incomeSource) {
        return incomeService.addNewIncomeSource(incomeSource);
    }

    @DeleteMapping("/removeIncome/{id}")
    public String removeIncome(@PathVariable Integer id) {
        return incomeService.RemoveIncomeSource(id);
    }

    @PutMapping("/updateIncome")
    public Income updateIncome(@RequestBody Income income) {
        return incomeService.UpdateIncomeSource(income);
    }

    @DeleteMapping("/clearAll")
    public String clearAllIncome() {
        incomeService.clearAllIncome();
        return "All income cleared successfully!";
    }
}