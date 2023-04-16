package com.ecommerce.core.creditcard;


import com.ecommerce.core.basket.BasketEntityRepository;
import com.ecommerce.core.basket.BasketService;
import com.ecommerce.core.user.UserEntityRepository;
import com.ecommerce.core.user.UserMapperImpl;
import com.ecommerce.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private CreditCardEntityRepository creditCardEntityRepository;

    @Autowired
    private UserService userService;

    public CreditCardDTO addCard(CreditCardDTO creditCardDTO){

        CreditCardEntity creditCardEntity = CreditCardMapperImpl.toEntity(creditCardDTO);

        creditCardEntity.setUserEntity(userService.getCurrentUser());

        creditCardEntityRepository.save(creditCardEntity);


        creditCardDTO.setId(creditCardEntity.getId());

        return creditCardDTO;

    }
}
