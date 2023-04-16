package com.ecommerce.core.user;

public class UserMapperImpl {
    public static UserDTO toDTO(UserEntity userEntity) {

        UserDTO dto = new UserDTO();

        if(userEntity == null){
            return null;
        }

        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        dto.setPhoneNumber(userEntity.getPhoneNumber());
        dto.setEmail(userEntity.getEmail());


        return dto;
    }

    public static void toEntity(UserDTO user, UserEntity userEntity) {
        userEntity.setId(user.getId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setEmail(user.getEmail());

    }

    public static UserEntity toEntity(UserDTO user) {

        UserEntity result = new UserEntity();

        result.setId(user.getId());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setUsername(user.getUsername());
        result.setPassword(user.getPassword());
        result.setPhoneNumber(user.getPhoneNumber());
        result.setEmail(user.getEmail());

        return result;
    }



}
