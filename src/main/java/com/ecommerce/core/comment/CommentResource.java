package com.ecommerce.core.comment;


import com.ecommerce.core.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/addComment")
    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok(commentService.addComment(commentDTO));
    }

    @GetMapping(path = "/getComments/{id}")
    public ResponseEntity<List<CommentDTO>> getComments(@PathVariable("id") Long id){
        return ResponseEntity.ok(commentService.getComments(id));
    }

}
