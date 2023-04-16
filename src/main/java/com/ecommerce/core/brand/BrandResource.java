package com.ecommerce.core.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private")
public class BrandResource {

    @Autowired
    private BrandService brandService;

    @PostMapping(path = "/addBrand")
    public ResponseEntity<BrandDTO> addBrand(@RequestBody BrandDTO brand){
        return ResponseEntity.ok(brandService.addBrand(brand));
    }

    @GetMapping(path = "/brands")
    public ResponseEntity<List<BrandDTO>> getBrands() {
        return ResponseEntity.ok(brandService.getBrands());
    }

    @GetMapping(path = "/deleteBrand/{id}")
    public ResponseEntity<Boolean> addBrand(@PathVariable("id") Long id){
        return ResponseEntity.ok(brandService.deleteBrand(id));
    }
}
