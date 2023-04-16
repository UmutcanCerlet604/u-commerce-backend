package com.ecommerce.core.brand;

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

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BrandServiceTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandEntityRepository brandEntityRepository;


    @Test
    @Order(1)
    public void addBrand(){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandName("Apple");
        BrandDTO savedBrandDTO = brandService.addBrand(brandDTO);

        Boolean exist = brandEntityRepository.existsById(savedBrandDTO.getId());
        assertThat(exist).isTrue();
    }

    @Test
    @Order(2)
    public void getBrands(){
        List<BrandDTO> brandDTOList = brandService.getBrands();
        assertThat(brandDTOList).isNotNull();
    }

    //@Test
    //@Order(3)
    //public void update(){
      // BrandDTO brandDTO = new BrandDTO();
      // brandDTO.setId(findId("Apple"));
      // brandDTO.setBrandName("Huawei");
      // BrandDTO brandDTO1 = brandService.addBrand(brandDTO);
      // assertThat(brandDTO1.getBrandName()).isEqualTo("Huawei");
    //}




    //Long findId(String name){
//       BrandEntity brandEntity = brandService.findByName(name);
//        return brandEntity.getId();
//    }
}