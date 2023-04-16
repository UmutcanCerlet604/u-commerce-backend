package com.ecommerce.core.product;

import com.ecommerce.core.category.CategoryMapperImpl;

import java.io.Serializable;

public class
ProductMapperImpl implements Serializable {

    public static ProductDTO toDto(ProductEntity productEntity){

        ProductDTO result = new ProductDTO();

        result.setId(productEntity.getId());
        result.setName(productEntity.getName());
        result.setPrice(productEntity.getPrice());
        result.setDescription(productEntity.getDescription());
        result.setImageUrl(productEntity.getImageUrl());
        result.setPiece(productEntity.getPiece());
        result.setCategoryId(productEntity.getCategoryEntity().getId());
        result.setBrandId(productEntity.getBrandEntity().getId());

        return result;
    }

    public static ProductEntity toEntity(ProductDTO productDTO){

        ProductEntity result = new ProductEntity();

        result.setId(productDTO.getId());
        result.setName(productDTO.getName());
        result.setPrice(productDTO.getPrice());
        result.setDescription(productDTO.getDescription());
        result.setImageUrl(productDTO.getImageUrl());
        result.setPiece(productDTO.getPiece());

        return result;
    }


}
