package com.ecommerce.core.user;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRoleEntityRepository userRoleEntityRepository;

    @Test
    @Order(1)
    public void addUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Umut");
        userDTO.setPassword("umut");
        userDTO.setFirstName("Umutcan");
        userDTO.setLastName("Cerlet");
        userDTO.setPhoneNumber("05447139461");
        userDTO.setEmail("umut@hiraparl.com");
        UserDTO result = userService.addUser(userDTO);

        UserEntity userEntity = UserMapperImpl.toEntity(userService.addUser(userDTO));
        Boolean exist = userEntityRepository.existsById(userEntity.getId());
        assertThat(exist).isTrue();
    }

    @Test
    @Order(2)
    public void findByUsername(){
        UserEntity exist = userService.findByUsername("Umut");
        assertThat(exist).isNotNull();
    }


}