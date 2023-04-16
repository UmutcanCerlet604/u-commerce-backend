package com.ecommerce.core.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {

//    CategoryEntity findByCategoryName(String name);
}
