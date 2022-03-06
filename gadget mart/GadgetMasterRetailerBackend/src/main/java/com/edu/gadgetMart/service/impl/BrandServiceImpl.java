

package com.edu.gadgetMart.service.impl;

import com.edu.gadgetMart.entity.Brand;
import com.edu.gadgetMart.exception.RecordNotFoundException;
import com.edu.gadgetMart.repository.BrandRepository;
import com.edu.gadgetMart.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    private static final String MSG = "Brand not Found";

    @Override
    public Brand addBrand(Brand brand) {
        brand.setStatus("1");
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(long id, Brand brand) {
        Brand brand1 = brandRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (brand1 == null) {
            return null;
        } else {
            if (brand1.getStatus().equalsIgnoreCase("1")){
                brand.setId(brand1.getId());
                brand.setStatus("1");
                return brandRepository.save(brand);
            }else{
                return null;
            }
        }
    }

    @Override
    public Brand deleteBrand(long id) {
        Brand brand1 = brandRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));
        if (brand1 == null) {
            return null;
        } else {
            brand1.setStatus("0");
            return brandRepository.save(brand1);
        }
    }

    @Override
    public Brand searchBrand(long id) {
        return brandRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(MSG));

    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
