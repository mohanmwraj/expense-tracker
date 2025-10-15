package com.mohan.expense_tracker_app.controller;

import com.mohan.expense_tracker_app.dto.CategoryDto;
import com.mohan.expense_tracker_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    //Build create category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.createCategory(categoryDto);
       // return ResponseEntity.ok(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // Build Get Category by Id Rest API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){

        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto){
        CategoryDto updateCategory = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(updateCategory);
    }

    @GetMapping
        public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category Deleted Successfully");
    }
}
