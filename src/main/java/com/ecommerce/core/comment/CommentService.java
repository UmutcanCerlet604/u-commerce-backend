package com.ecommerce.core.comment;

import com.ecommerce.core.product.ProductDTO;
import com.ecommerce.core.product.ProductService;
import com.ecommerce.core.user.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentEntityRepository commentEntityRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public CommentDTO addComment(CommentDTO commentDTO){
        commentEntityRepository.save(CommentMapperImpl.toEntity(commentDTO));
        return commentDTO;
    }

    public List<CommentDTO> getComments(Long id){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        commentEntityRepository.findAll().stream().filter(e -> e.getProductEntity().getId().equals(id)).forEach(commentEntity -> {
            commentDTOList.add(CommentMapperImpl.toDto(commentEntity));
        });

        return commentDTOList;

    }


}
