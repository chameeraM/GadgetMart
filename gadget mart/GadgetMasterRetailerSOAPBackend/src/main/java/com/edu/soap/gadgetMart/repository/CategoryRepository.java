
package com.edu.soap.gadgetMart.repository;

import com.edu.soap.gadgetMart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
