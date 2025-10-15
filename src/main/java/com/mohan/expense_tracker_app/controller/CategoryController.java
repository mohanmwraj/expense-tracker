package com.mohan.expense_tracker_app.controller;

import com.mohan.expense_tracker_app.dto.CategoryDto;
import com.mohan.expense_tracker_app.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource - Create Category" +
                "update Category, Get Category and Delete Category"
)


@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Operation(
        summary = "Create Category REST API",
            description = "Create Category REST API to save category into database"
    )

    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    //Build create category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.createCategory(categoryDto);
       // return ResponseEntity.ok(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET Category REST API",
            description = "Get Category REST API to get category from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    // Build Get Category by Id Rest API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){

        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(categoryDto);
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API to category in a database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto){
        CategoryDto updateCategory = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(updateCategory);
    }

    @Operation(
            summary = "GET All Category REST API",
            description = "Get All Category REST API to get all categories from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
        public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @Operation(
            summary = "DELETE Category REST API",
            description = "DELETE Category REST API to delete categories from the database"
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category Deleted Successfully");
    }
}
