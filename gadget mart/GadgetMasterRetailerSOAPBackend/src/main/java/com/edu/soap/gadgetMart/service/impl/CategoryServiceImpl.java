

package com.edu.soap.gadgetMart.service.impl;


import com.edu.soap.gadgetMart.entity.Category;
import com.edu.soap.gadgetMart.exception.RecordNotFoundException;
import com.edu.soap.gadgetMart.repository.CategoryRepository;
import com.edu.soap.gadgetMart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private static final String MSG = "Category not Found";

    @Override
    public Category addCategory(Category category) {
        category.setStatus("1");
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(long id, Category category) {
        Category category1 = categoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (category1 == null) {
            return null;
        } else {
            if (category1.getStatus().equalsIgnoreCase("1")){
                category.setStatus("1");
                category.setId(category1.getId());
                return categoryRepository.save(category);
            }else{
                return null;
            }

        }
    }

    @Override
    public Category deleteCategory(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (category == null) {
            return null;
        } else {
            category.setStatus("0");
            return categoryRepository.save(category);

        }
    }

    @Override
    public Category searchCategory(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
    }

    @Override
    public List<Category> getAllCategorys() {
        return categoryRepository.findAll();
    }
}
