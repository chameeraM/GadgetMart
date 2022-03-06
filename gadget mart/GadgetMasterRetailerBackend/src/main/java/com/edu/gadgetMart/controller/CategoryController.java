
package com.edu.gadgetMart.controller;

import com.edu.gadgetMart.entity.Category;
import com.edu.gadgetMart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addCategory(@RequestBody Category category) {
        Category category1 = categoryService.addCategory(category);
        if (category1 == null) {
            return new ResponseEntity(category1, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(category1, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteCategory(@PathVariable(value = "id") long id) {
        Category category = categoryService.deleteCategory(id);
        if (category == null) {
            return new ResponseEntity(category, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(category, HttpStatus.OK);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllCategorys() {
        List<Category> allCategorys = categoryService.getAllCategorys();
        if (allCategorys == null) {
            return new ResponseEntity(allCategorys, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(allCategorys, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateCategory(@PathVariable(value = "id") long id, @RequestBody Category category) {
        Category category1 = categoryService.updateCategory(id, category);
        if (category1 == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(category1, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity searchCategory(@PathVariable(value = "id") long id) {
        Category category = categoryService.searchCategory(id);
        if (category == null) {
            return new ResponseEntity(category, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(category, HttpStatus.OK);
        }
    }
}
