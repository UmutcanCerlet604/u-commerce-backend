package com.ecommerce.core.category;

import com.ecommerce.core.basket.BasketEntityRepository;
import com.ecommerce.core.comment.CommentEntityRepository;
import com.ecommerce.core.product.ProductEntityRepository;
import com.ecommerce.core.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private ProductService productService;

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        CategoryEntity categoryEntity = null;
        if (categoryDTO.getId() != null){
            categoryEntity = categoryEntityRepository.findById(categoryDTO.getId()).get();
            CategoryMapperImpl.toEntity(categoryDTO, categoryEntity);
            categoryEntityRepository.save(categoryEntity);
        }
        else {
            CategoryEntity entity = CategoryMapperImpl.toEntity(categoryDTO);
            CategoryEntity result = categoryEntityRepository.save(entity);
            categoryDTO.setId(result.getId());
        }

        return categoryDTO;
    }


    public List<CategoryDTO> getCategories(){

        List<CategoryEntity> categoryEntityList = categoryEntityRepository.findAll();

        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        categoryEntityList.stream().forEach(categoryEntity -> {
            categoryDTOList.add(CategoryMapperImpl.toDto(categoryEntity));
        });


        return categoryDTOList;
    }

    public Boolean deleteCategory(Long id) {

        productEntityRepository.findAll().stream().forEach(entity -> {
            if (entity.getCategoryEntity().getId().equals(id)){
                productService.deleteProduct(entity.getId());
            }
        });

        categoryEntityRepository.deleteById(id);
        return Boolean.TRUE;
    }
//
//    public CategoryEntity findCategoryById(CategoryEntity categoryEntity){
//        Optional<CategoryEntity> opt = categoryEntityRepository.findById(categoryEntity.getId());
//
//        if (opt.isPresent()){
//            return opt.get();
//        }
//
//        return null;
//    }

//    public CategoryEntity findByName(String name){
//
//       return categoryEntityRepository.findByCategoryName(name);
//
//    }
}
