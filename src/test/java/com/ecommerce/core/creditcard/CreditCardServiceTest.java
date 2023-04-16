package com.ecommerce.core.creditcard;

import com.ecommerce.core.user.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CreditCardServiceTest {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CreditCardEntityRepository creditCardEntityRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntityRepository userEntityRepository;

//    @Test
//    @Order(1)
//    public void prepareTest(){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername("Berfin");
//        userDTO.setPassword("berfin");
//        userDTO.setFirstName("Berfin");
//        userDTO.setLastName("Gökmen");
//        userDTO.setPhoneNumber("0135454535");
//        userDTO.setEmail("berfin@hiraparl.com");
//
//        UserDTO result = userService.addUser(userDTO);
//
//        UserEntity userEntity = UserMapperImpl.toEntity(userService.addUser(userDTO));
//        Boolean exist = userEntityRepository.existsById(userEntity.getId());
//        assertThat(exist).isTrue();
//    }
//
//    @Test
//    @Order(2)
//    public void addCard(){
//
//        CreditCardDTO creditCardDTO = new CreditCardDTO();
//        creditCardDTO.setName("Berfin");
//        creditCardDTO.setCardNumber("1354354534534543435");
//        creditCardDTO.setSurname("Gökmen");
//        creditCardDTO.setDate("1524");
//        creditCardDTO.setCvv(5454L);
//        creditCardDTO.setUserId();
//
//        CreditCardDTO savedCreditCardDTO = creditCardService.addCard(creditCardDTO);
//
//        Boolean exist = creditCardEntityRepository.existsById(savedCreditCardDTO.getId());
//        assertThat(exist).isTrue();
//
//    }
}