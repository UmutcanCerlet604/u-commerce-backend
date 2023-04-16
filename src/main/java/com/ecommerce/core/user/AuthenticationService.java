package com.ecommerce.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationService implements AuthenticationProvider {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserService userService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        userService.createAdminIfNoUser();

        UserEntity userEntity = userEntityRepository.findByUsernameAndPassword(name, password);

        if (userEntity != null) {


            List<GrantedAuthority> autors = new ArrayList<>();

            autors.add(createAuthority(userEntity.getUserRole().getUserRole()));

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    name, password, autors);



            SecurityContextHolder.getContext().setAuthentication(authentication);

            return token;
        }

        if (userEntity == null) {
            throw new AuthenticationException("User not found") {
            };
        }

        return null;

    }

    private GrantedAuthority createAuthority(UserRoleEnum role) {
        GrantedAuthority ga = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return role.name();
            }
        };
        return ga;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
