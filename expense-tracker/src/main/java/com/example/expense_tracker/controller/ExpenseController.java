package com.example.expense_tracker.controller;

import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.service.ExpenseService;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    
    @Autowired
    private ExpenseService service;
    
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }


    // GET expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> result = service.getExpenseById(id);
    
        if (result.isPresent()) {
            // Expense found - return 200 OK with the expense
            Expense expense = result.get();
            return ResponseEntity.ok(expense);
        } else {
            // Expense not found - return 404 NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }

    // POST create new expense
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        
        return service.saveExpense(expense);
    }

    // PUT update expense
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        Optional<Expense> existingExpense = service.getExpenseById(id);
    
        if (existingExpense.isEmpty()) {
            return ResponseEntity.notFound().build();  // 404 if doesn't exist
        }
        
        // Update the expense
        expense.setId(id);
        Expense updatedExpense = service.saveExpense(expense);
        return ResponseEntity.ok(updatedExpense);  // 200 if updated
    }

    // DELETE expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
    
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();

    }
}
