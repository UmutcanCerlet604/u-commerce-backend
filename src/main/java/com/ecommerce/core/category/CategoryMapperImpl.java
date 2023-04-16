package com.ecommerce.core.category;

import java.io.Serializable;

public class CategoryMapperImpl implements Serializable {
    public static CategoryDTO toDto(CategoryEntity categoryEntity) {

        CategoryDTO result = new CategoryDTO();
        result.setId(categoryEntity.getId());
        result.setName(categoryEntity.getName());

        return result;
    }

    public static CategoryEntity toEntity(CategoryDTO categoryDTO) {

        CategoryEntity result = new CategoryEntity();
        result.setId(categoryDTO.getId());
        result.setName(categoryDTO.getName());

        return result;
    }

    public static void toEntity(CategoryDTO category, CategoryEntity entity){

        entity.setId(category.getId());
        entity.setName(category.getName());

    }

}
