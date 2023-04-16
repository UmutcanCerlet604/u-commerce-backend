package com.ecommerce.core.category;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;

    @Test
    @Order(1)
    public void addCategory(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("Telefon");
        CategoryDTO savedCategoryDTO = categoryService.addCategory(categoryDTO);

        Boolean exist = categoryEntityRepository.existsById(savedCategoryDTO.getId());
        assertThat(exist).isTrue();
    }

    @Test
    @Order(2)
    public void getCategories(){
        List<CategoryDTO> categoryDTOList = categoryService.getCategories();
        assertThat(categoryDTOList).isNotNull();
    }

//    @Test
//    @Order(3)
//    public void update(){
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setId(categoryService.findCategoryById(categoryEntity.getId()));
//        categoryDTO.setName("Bilgisayar");
//        CategoryDTO categoryDTO1 = categoryService.addCategory(categoryDTO);
//        assertThat(categoryDTO1.getName()).isEqualTo("Bilgisayar");
//    }

//
//    Long findId(String name){
//        CategoryEntity categoryEntity = categoryService.findByName(name);
//        return categoryEntity.getId();
//    }
}