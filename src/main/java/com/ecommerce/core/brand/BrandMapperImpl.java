package com.ecommerce.core.brand;

import java.io.Serializable;

public class BrandMapperImpl implements Serializable {

    public static BrandDTO toDto(BrandEntity brandEntity) {

        BrandDTO result = new BrandDTO();
        result.setId(brandEntity.getId());
        result.setBrandName(brandEntity.getBrandName());

        return result;
    }

    public static BrandEntity toEntity(BrandDTO brandDTO) {

        BrandEntity result = new BrandEntity();
        result.setId(brandDTO.getId());
        result.setBrandName(brandDTO.getBrandName());

        return result;
    }

    public static void toEntity(BrandDTO brand, BrandEntity entity){
        entity.setId(brand.getId());
        entity.setBrandName(brand.getBrandName());
    }
}
