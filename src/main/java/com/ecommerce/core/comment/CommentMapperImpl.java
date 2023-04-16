package com.ecommerce.core.comment;


import com.ecommerce.core.product.ProductMapperImpl;
import com.ecommerce.core.user.UserMapperImpl;


import java.io.Serializable;

public class CommentMapperImpl implements Serializable {

    public static CommentDTO toDto(CommentEntity commentEntity){

        CommentDTO result = new CommentDTO();
        result.setId(commentEntity.getId());
        result.setProductComment(commentEntity.getProductComment());
        result.setRating(commentEntity.getRating());
        result.setProduct(ProductMapperImpl.toDto(commentEntity.getProductEntity()));
        result.setUser(UserMapperImpl.toDTO(commentEntity.getUserEntity()));

        return result;

    }

    public static CommentEntity toEntity(CommentDTO commentDTO){

        CommentEntity result = new CommentEntity();
        result.setId(commentDTO.getId());
        result.setProductComment(commentDTO.getProductComment());
        result.setRating(commentDTO.getRating());
        result.setProductEntity(ProductMapperImpl.toEntity(commentDTO.getProduct()));
        result.setUserEntity(UserMapperImpl.toEntity(commentDTO.getUser()));

        return result;

    }
}
