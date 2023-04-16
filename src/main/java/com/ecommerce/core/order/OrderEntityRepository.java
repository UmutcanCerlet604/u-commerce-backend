package com.ecommerce.core.order;


import com.ecommerce.core.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

}
