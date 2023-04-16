package com.ecommerce.core.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/addCategory")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<List<CategoryDTO>> addCategory() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping(path = "/deleteCategory/{id}")
    public ResponseEntity<Boolean> addCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}



