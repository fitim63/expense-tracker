package com.codeengine.expenseTracker.repository;

import com.codeengine.expenseTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
