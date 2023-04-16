package com.ecommerce.core.brand;

import com.ecommerce.core.basket.BasketEntityRepository;
import com.ecommerce.core.comment.CommentEntityRepository;
import com.ecommerce.core.product.ProductEntityRepository;
import com.ecommerce.core.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandEntityRepository brandEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private ProductService productService;

    public BrandDTO addBrand(BrandDTO brandDTO){

        BrandEntity brandEntity = null;
        if (brandDTO.getId() != null){
            brandEntity = brandEntityRepository.findById(brandDTO.getId()).get();
            BrandMapperImpl.toEntity(brandDTO, brandEntity);
            brandEntityRepository.save(brandEntity);
        }
        else{
            BrandEntity entity = BrandMapperImpl.toEntity(brandDTO);
            BrandEntity result = brandEntityRepository.save(entity);
            brandDTO.setId(result.getId());
        }

        return brandDTO;
    }

    public List<BrandDTO> getBrands(){

        List <BrandEntity> brandEntityList = brandEntityRepository.findAll();

        List <BrandDTO> brandDTOList = new ArrayList<>();

        brandEntityList.stream().forEach(brandEntity -> {
            brandDTOList.add(BrandMapperImpl.toDto(brandEntity));
        });

        return brandDTOList;
    }

    public Boolean deleteBrand(Long id){

        productEntityRepository.findAll().stream().forEach(entity -> {
            if (entity.getBrandEntity().getId().equals(id)){
                productService.deleteProduct(entity.getId());
            }
        });


        brandEntityRepository.deleteById(id);
        return Boolean.TRUE;
    }

//    public BrandEntity findByName(String name){
//
//       return brandEntityRepository.findByBrandName(name);
//    }


}
