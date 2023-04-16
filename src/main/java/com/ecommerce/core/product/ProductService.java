package com.ecommerce.core.product;

import com.ecommerce.core.basket.BasketEntityRepository;
import com.ecommerce.core.brand.BrandEntity;
import com.ecommerce.core.brand.BrandEntityRepository;
import com.ecommerce.core.category.CategoryEntity;
import com.ecommerce.core.category.CategoryEntityRepository;
import com.ecommerce.core.comment.CommentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;

    @Autowired
    private BrandEntityRepository brandEntityRepository;

    @Autowired
    private BasketEntityRepository basketEntityRepository;

    @Autowired
    private CommentEntityRepository commentEntityRepository;

    @Autowired
    private ProductService productService;

    public ProductDTO addProduct(ProductDTO productDTO){

        ProductEntity productEntity;
        CategoryEntity categoryEntity = categoryEntityRepository.findById(productDTO.getCategoryId()).get();
        BrandEntity brandEntity = brandEntityRepository.findById(productDTO.getBrandId()).get();

        if (productDTO.getId() != null){
            productEntity = ProductMapperImpl.toEntity(productDTO);
            productEntity.setCategoryEntity(categoryEntity);
            productEntity.setBrandEntity(brandEntity);
            productEntityRepository.save(productEntity);
        }
        else{
            productEntity = ProductMapperImpl.toEntity(productDTO);
            productEntity.setCategoryEntity(categoryEntity);
            productEntity.setBrandEntity(brandEntity);
            productEntityRepository.save(productEntity);
        }

        return productDTO;
    }

    public List<ProductDTO>getProducts(){

        List<ProductEntity> productEntityList = productEntityRepository.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();

        productEntityList.stream().forEach(productEntity -> {
            productDTOList.add(ProductMapperImpl.toDto(productEntity));
        });

        return productDTOList;

    }

    public Boolean deleteProduct(Long id){

        commentEntityRepository.findAll().stream().forEach(commentEntity ->{

            if (commentEntity.getProductEntity().getId().equals(id)){
                commentEntityRepository.deleteById(commentEntity.getId());
            }
        });

        basketEntityRepository.findAll().stream().forEach(basketEntity ->{

            if (basketEntity.getProductEntity().getId().equals(id)){
                basketEntityRepository.deleteById(basketEntity.getId());
            }
        });

        productEntityRepository.deleteById(id);
        return Boolean.TRUE;
    }


    public ProductDTO findByProduct(Long id){
        return ProductMapperImpl.toDto(productEntityRepository.findById(id).get());
    }


}
