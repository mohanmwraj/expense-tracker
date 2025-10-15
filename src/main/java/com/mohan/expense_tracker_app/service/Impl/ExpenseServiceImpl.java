package com.mohan.expense_tracker_app.service.Impl;

import com.mohan.expense_tracker_app.dto.ExpenseDto;
import com.mohan.expense_tracker_app.entity.Category;
import com.mohan.expense_tracker_app.entity.Expense;
import com.mohan.expense_tracker_app.mapper.ExpenseMapper;
import com.mohan.expense_tracker_app.repository.CategoryRepository;
import com.mohan.expense_tracker_app.repository.ExpenseRepository;
import com.mohan.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    private CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);

        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .map(ExpenseMapper::mapToExpenseDto)
                .toList();
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if(expenseDto.categoryDto() != null){

            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + expenseDto.categoryDto().id()));

            expense.setCategory(category);
        }

        Expense updateExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(updateExpense);

    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));

        expenseRepository.delete(expense);
    }
}
