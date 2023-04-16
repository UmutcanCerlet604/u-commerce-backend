package com.ecommerce.core.basket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/private")
public class BasketResource {

    @Autowired
    private BasketService basketService;

    @PostMapping("/addToBasket")
    public ResponseEntity<BasketDTO> addToBasket(@RequestBody BasketDTO basketDTO){
        return ResponseEntity.ok(basketService.addToBasket(basketDTO));
    }

    @GetMapping("/basketGetAll/{id}")
    public ResponseEntity<List<BasketDTO>> getAll(@PathVariable("id") Long id){
        return ResponseEntity.ok(basketService.getAll(id));
    }

    @GetMapping("/deleteBasket/{id}")
    public ResponseEntity<Boolean> deleteBasket(@PathVariable("id") Long id){
        return ResponseEntity.ok(basketService.delete(id));
    }

    @GetMapping("/increase/{id}")
    public ResponseEntity<List<BasketDTO>> increase(@PathVariable("id") Long id){
        return ResponseEntity.ok(basketService.increase(id));
    }

    @GetMapping("/decrease/{id}")
    public ResponseEntity<List<BasketDTO>> decrease(@PathVariable("id") Long id){
        return ResponseEntity.ok(basketService.decrease(id));
    }

}
