package com.ecommerce.core.creditcard;

import com.ecommerce.core.user.UserEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Entity
@Data
@Table
public class CreditCardEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecommerce_generator")
    @SequenceGenerator(name = "ecommerce_generator", sequenceName = "ecommerce_seq", allocationSize = 50)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String cardNumber;

    @Column
    private Long cvv;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;

}
