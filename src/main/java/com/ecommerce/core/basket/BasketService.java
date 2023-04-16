package com.ecommerce.core.basket;

import com.ecommerce.core.user.UserEntity;
import com.ecommerce.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class  BasketService {

    private Boolean e = true;

    @Autowired
    private UserService userService;

    @Autowired
    private BasketEntityRepository basketEntityRepository;

    public BasketDTO addToBasket(BasketDTO basketDTO){

        basketEntityRepository.findAll().stream().forEach(res ->{
            if (res.getProductEntity().getId().equals(basketDTO.getProduct().getId()) && res.getUserEntity().getId().equals(basketDTO.getUser().getId())){
                BasketEntity basketEntity = basketEntityRepository.findById(res.getId()).get();
                basketEntity.setQuantity(basketEntity.getQuantity()+1L);
                basketEntityRepository.save(basketEntity);
                e = false;
                return;
            }

        });
        if (e) {
            BasketEntity basketEntity = BasketMapperImpl.toEntity(basketDTO);
            basketEntity.setQuantity(1L);
            basketEntityRepository.save(basketEntity);
        }

        return basketDTO;
    }


    public List<BasketDTO>getAll(Long id) {
        List<BasketDTO> basketDTOList = new ArrayList<>();
        basketEntityRepository.findAll().stream().filter(e -> e.getUserEntity().getId().equals(id)).forEach(basketEntity ->{
            basketDTOList.add(BasketMapperImpl.toDto(basketEntity));
        });

        return basketDTOList;
    }


    public Boolean delete(Long id){
        basketEntityRepository.deleteById(id);
        return true;
     }


     public List<BasketDTO> increase(Long id){

        basketEntityRepository.findAll().stream().filter(e -> e.getUserEntity().getId().equals
                (userService.getCurrentUser().getId()) && e.getProductEntity().getId().equals(id)).forEach(entity -> {
                    entity.setQuantity(entity.getQuantity()+1L);
                    basketEntityRepository.save(entity);
        });

        return getAll(userService.getCurrentUser().getId());
    }

    public List<BasketDTO> decrease(Long id){

        basketEntityRepository.findAll().stream().filter(e -> e.getUserEntity().getId().equals
                (userService.getCurrentUser().getId()) && e.getProductEntity().getId().equals(id)).forEach(entity -> {
            entity.setQuantity(entity.getQuantity()-1L);
            basketEntityRepository.save(entity);
        });

        return getAll(userService.getCurrentUser().getId());
    }



}
