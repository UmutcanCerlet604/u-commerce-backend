package com.ecommerce.core.creditcard;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class CreditCardDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String cardNumber;
    private Long cvv;
    private String date;
    private Long userId;


}
