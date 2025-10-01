package com.mohan.expense_tracker_app.service.Impl;

import com.mohan.expense_tracker_app.dto.CategoryDto;
import com.mohan.expense_tracker_app.entity.Category;
import com.mohan.expense_tracker_app.mapper.CategoryMapper;
import com.mohan.expense_tracker_app.repository.CategoryRepository;
import com.mohan.expense_tracker_app.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService  {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        //Convert CategoryDto to Category Entity
        Category category = CategoryMapper.mapToCategory(categoryDto);

        // Save Category Object into database table - categories
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::mapToCategoryDto)
                .toList();

        //return List.of();
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " +categoryId));

        category.setName(categoryDto.name());
        Category updateCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(updateCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        categoryRepository.delete(category);
    }
}
