package com.mohan.expense_tracker_app.repository;

import com.mohan.expense_tracker_app.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Spring Data JPA provides implementations for this interface
    // CRUD methods to perform CRUD database operations on Expense entity
    // Spring Data JPA provides transaction for all the CRUD methods.
}
