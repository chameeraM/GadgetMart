

package com.edu.gadgetMart.controller;

import com.edu.gadgetMart.entity.SubCategory;
import com.edu.gadgetMart.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/sub-category")
@CrossOrigin
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addSubCategory(@RequestBody SubCategory subCategory) {
        SubCategory subCategory1 = subCategoryService.addSubCategory(subCategory);
        if (subCategory1 == null) {
            return new ResponseEntity(subCategory1, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(subCategory1, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteSubCategory(@PathVariable(value = "id") long id) {
        SubCategory subCategory = subCategoryService.deleteSubCategory(id);
        if (subCategory == null) {
            return new ResponseEntity(subCategory, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(subCategory, HttpStatus.OK);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllSubCategorys() {
        List<SubCategory> allSubCategorys = subCategoryService.getAllSubCategorys();
        if (allSubCategorys == null) {
            return new ResponseEntity(allSubCategorys, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(allSubCategorys, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateSubCategory(@PathVariable(value = "id") long id, SubCategory subCategory) {
        SubCategory subCategory1 = subCategoryService.updateSubCategory(id, subCategory);
        if (subCategory1 == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(subCategory1, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity searchSubCategory(@PathVariable(value = "id") long id) {
        SubCategory subCategory = subCategoryService.searchSubCategory(id);
        if (subCategory == null) {
            return new ResponseEntity(subCategory, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(subCategory, HttpStatus.OK);
        }
    }
}
