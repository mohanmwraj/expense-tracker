package com.mohan.expense_tracker_app.repository;

import com.mohan.expense_tracker_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
