package com.ecommerce.core.comment;

import com.ecommerce.core.product.ProductEntity;
import com.ecommerce.core.user.UserEntity;
import lombok.Data;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table

public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 511)
    private String productComment;

    @Column (nullable = true)
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private ProductEntity productEntity;

}
