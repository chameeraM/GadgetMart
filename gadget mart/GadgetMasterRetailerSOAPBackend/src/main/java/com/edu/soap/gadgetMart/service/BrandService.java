
package com.edu.soap.gadgetMart.service;

import com.edu.soap.gadgetMart.entity.Brand;

import java.util.List;

public interface BrandService {

    public Brand addBrand(Brand brand);

    public Brand updateBrand(long id, Brand brand);

    public Brand deleteBrand(long id);

    public Brand searchBrand(long id);

    public List<Brand> getAllBrands();

}
