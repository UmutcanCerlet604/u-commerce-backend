package com.ecommerce.core.creditcard;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardEntityRepository extends JpaRepository<CreditCardEntity, Long> {

}
