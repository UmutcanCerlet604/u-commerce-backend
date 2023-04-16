package com.ecommerce.core.basket;

import com.ecommerce.core.product.ProductEntityRepository;
import com.ecommerce.core.product.ProductMapperImpl;
import com.ecommerce.core.user.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BasketMapperImpl implements Serializable {

    @Autowired
    ProductEntityRepository productEntityRepository;

    public static BasketDTO toDto(BasketEntity basketEntity){

        BasketDTO result = new BasketDTO();
        result.setId(basketEntity.getId());
        result.setQuantity(basketEntity.getQuantity());
        result.setProduct(ProductMapperImpl.toDto(basketEntity.getProductEntity()));
        result.setUser(UserMapperImpl.toDTO(basketEntity.getUserEntity()));

        return result;
    }

    public static BasketEntity toEntity(BasketDTO basketDTO){

        BasketEntity result = new BasketEntity();
        result.setId(basketDTO.getId());
        result.setQuantity(basketDTO.getQuantity());
        result.setProductEntity(ProductMapperImpl.toEntity(basketDTO.getProduct()));
        result.setUserEntity(UserMapperImpl.toEntity(basketDTO.getUser()));

        return result;
    }

    public static void toEntity(BasketDTO basket, BasketEntity entity){

        entity.setId(basket.getId());
        entity.setQuantity(basket.getQuantity());
    }

}
