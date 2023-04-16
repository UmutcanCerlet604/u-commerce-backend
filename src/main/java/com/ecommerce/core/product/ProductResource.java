package com.ecommerce.core.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/addProduct")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.addProduct(productDTO));
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(path = "/deleteProduct/{id}")
    public ResponseEntity<Boolean> addProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping(path = "/productDetail/{id}")
    public ResponseEntity<ProductDTO> findByProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.findByProduct(id));
    }


}
