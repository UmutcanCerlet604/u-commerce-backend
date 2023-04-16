package com.ecommerce.core.comment;


import com.ecommerce.core.product.ProductDTO;
import com.ecommerce.core.user.UserDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CommentDTO implements Serializable {

    private Long id;
    private String productComment;
    private Double rating;
    private UserDTO user;
    private ProductDTO product;

}
