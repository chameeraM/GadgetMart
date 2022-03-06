

package com.edu.gadgetMart.service;



import com.edu.gadgetMart.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {

    public SubCategory addSubCategory(SubCategory subCategory);

    public SubCategory updateSubCategory(long id, SubCategory subCategory);

    public SubCategory deleteSubCategory(long id);

    public SubCategory searchSubCategory(long id);

    public List<SubCategory> getAllSubCategorys();
}
