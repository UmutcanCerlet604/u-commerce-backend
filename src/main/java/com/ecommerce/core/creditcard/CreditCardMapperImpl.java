package com.ecommerce.core.creditcard;

import com.ecommerce.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreditCardMapperImpl {



    public static CreditCardDTO toDto(CreditCardEntity creditCardEntity){

        CreditCardDTO result = new CreditCardDTO();

        result.setId(creditCardEntity.getId());
        result.setName(creditCardEntity.getName());
        result.setSurname(creditCardEntity.getSurname());
        result.setCardNumber(creditCardEntity.getCardNumber());
        result.setCvv(creditCardEntity.getCvv());
        result.setDate(creditCardEntity.getDate());
        result.setUserId(creditCardEntity.getUserEntity().getId());

        return result;

    }

    public static CreditCardEntity toEntity(CreditCardDTO creditCardDTO){

        CreditCardEntity result = new CreditCardEntity();

        if (creditCardDTO.getId() != null){
            result.setId(creditCardDTO.getId());
        }

        result.setName(creditCardDTO.getName());
        result.setSurname(creditCardDTO.getSurname());
        result.setCardNumber(creditCardDTO.getCardNumber());
        result.setCvv(creditCardDTO.getCvv());
        result.setDate(creditCardDTO.getDate());
        return result;
    }
}
