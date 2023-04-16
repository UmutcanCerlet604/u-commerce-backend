package com.ecommerce.core.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class CreditCardResource {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping(path = "/addCard")
    public ResponseEntity<CreditCardDTO> addCard(@RequestBody CreditCardDTO creditCardDTO){
        return ResponseEntity.ok(creditCardService.addCard(creditCardDTO));
    }

}
