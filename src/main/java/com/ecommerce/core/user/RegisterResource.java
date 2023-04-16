package com.ecommerce.core.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class RegisterResource {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.addUser(userDTO));
    }
}
