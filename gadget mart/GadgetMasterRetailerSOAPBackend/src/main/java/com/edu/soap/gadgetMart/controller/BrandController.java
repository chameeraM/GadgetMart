

package com.edu.soap.gadgetMart.controller;

import com.edu.soap.gadgetMart.entity.Brand;
import com.edu.soap.gadgetMart.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/brand")
@CrossOrigin
public class BrandController {


    @Autowired
    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addBrand(@RequestBody Brand brand) {
        Brand brand1 = brandService.addBrand(brand);
        if (brand1 == null) {
            return new ResponseEntity(brand1, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(brand1, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteBrand(@PathVariable(value = "id") long id) {
        Brand brand = brandService.deleteBrand(id);
        if (brand == null) {
            return new ResponseEntity(brand, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(brand, HttpStatus.OK);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllBrands() {
        List<Brand> allBrands = brandService.getAllBrands();
        if (allBrands == null) {
            return new ResponseEntity(allBrands, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(allBrands, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateBrand(@PathVariable(value = "id") long id, Brand brand) {
        Brand brand1 = brandService.updateBrand(id, brand);
        if (brand1 == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(brand1, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity searchBrand(@PathVariable(value = "id") long id) {
        Brand brand = brandService.searchBrand(id);
        if (brand == null) {
            return new ResponseEntity(brand, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(brand, HttpStatus.OK);
        }
    }
}
