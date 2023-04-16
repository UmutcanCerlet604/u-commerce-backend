package com.ecommerce.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class AuthenticationResource {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public ResponseEntity<UserDTO> login() {

        UserEntity userEntity = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setFirstName(userEntity.getFirstName());
        userDTO.setLastName(userEntity.getLastName());

        userDTO.setUserRole(new UserRoleDTO());
        userDTO.getUserRole().setId(userEntity.getUserRole().getId());
        userDTO.getUserRole().setUserRole(userEntity.getUserRole().getUserRole().name());

        return ResponseEntity.ok(userDTO);
    }


}
