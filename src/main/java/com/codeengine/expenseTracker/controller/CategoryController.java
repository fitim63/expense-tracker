package com.codeengine.expenseTracker.controller;

import com.codeengine.expenseTracker.model.Category;
import com.codeengine.expenseTracker.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public Collection<Category> getCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Category> category = categoryRepository.findById(id);

        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepository.save(category);

        return ResponseEntity.created(new URI("/api/category"+ result.getId())).body(result);

    }

    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
        Category result = categoryRepository.save(category);

        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<?> deleteCategory(@PathVariable Long id){

        categoryRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
