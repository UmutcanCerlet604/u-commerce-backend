package com.ecommerce.core.brand;

import com.ecommerce.core.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandEntityRepository extends JpaRepository<BrandEntity, Long> {

//    BrandEntity findByBrandName(String brandName);
}
