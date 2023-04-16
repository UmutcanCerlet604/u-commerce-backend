package com.ecommerce.core.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserRoleEntityRepository userRoleEntityRepository;

    @Transactional
    public UserDTO addUser(UserDTO userDTO){

        UserEntity userEntity = UserMapperImpl.toEntity(userDTO);
        UserRoleEntity userRoleEntity = new UserRoleEntity();

        userRoleEntity.setUserRole(UserRoleEnum.ROLE_USER);
        userRoleEntityRepository.save(userRoleEntity);

        userEntity.setUserRole(userRoleEntity);
        UserEntity savedEntity = userEntityRepository.save(userEntity);
        userDTO.setId(savedEntity.getId());

        return userDTO;
    }


    @Transactional
    protected void createAdminIfNoUser() {
        Iterable<UserEntity> users = userEntityRepository.findAll();

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        Boolean exists = ((Collection<?>) users).size() > 0;

        if (!exists) {
            log.info("Going to create Admin");
            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setFirstName("Umutcan");
            user.setLastName("Cerlet");
            user.setEmail("umutcan604cerlet@gmail.com");
            user.setPhoneNumber("05447139461");
            userRoleEntity.setUserRole(UserRoleEnum.ROLE_ADMIN);
            userRoleEntityRepository.save(userRoleEntity);
            user.setUserRole(userRoleEntity);
            userEntityRepository.save(user);
        }
    }

    @Transactional
    public UserEntity findByUsername(String username) {
        return userEntityRepository.findByUsername(username);
    }

    @Transactional
    public UserEntity getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity userEntity = userEntityRepository.findByUsername(username);

        return userEntity;

    }
}
