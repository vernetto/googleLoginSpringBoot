package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        log.info("userEntity: {}", userEntity);
        return userEntity;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public void updateUserDetails(UserDTO userDTO) {
        log.info("userDTO: {}", userDTO);
        UserEntity userEntity = getUser( userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPicture(userDTO.getPicture());
        userEntity.setTelephone(userDTO.getTelephone());
        userRepository.save(userEntity);
    }


    public UserEntity createNewUserWhenNeeded(OAuth2User oAuth2User) {
        UserEntity userEntity = oAuth2UserToUserEntity(oAuth2User);
        List<UserEntity> users = userRepository.findByEmail(userEntity.getEmail());
        log.info("users = {} " , users);
        if (users.isEmpty()) {
            UserEntity newUserEntity = userEntity;
            newUserEntity.setTelephone("");
            log.info("creating user = {} " , newUserEntity);
            userRepository.save(newUserEntity);
        }
        else {
            userEntity = users.get(0);
        }
        return userEntity;
    }

    /**
     * Creates a UserEntity with null id, populated from the Authenticated User
     * @param oAuth2User
     * @return
     */
    public UserEntity oAuth2UserToUserEntity(OAuth2User oAuth2User) {
        String name = (String)(oAuth2User.getAttributes().get("name"));
        String picture = (String)(oAuth2User.getAttributes().get("picture"));
        String email = (String)(oAuth2User.getAttributes().get("email"));
        UserEntity userEntity = new UserEntity(null, name, "", email, picture);
        return userEntity;
    }

    public UserEntity getCurrentUser() {
        UserEntity userEntity = null;
        Authentication authenticationFromContext = SecurityContextHolder.getContext().getAuthentication();
        if (authenticationFromContext != null && authenticationFromContext.getPrincipal() instanceof OAuth2User) {
            OAuth2User oAuth2User = (OAuth2User) authenticationFromContext.getPrincipal();
            log.info("user from context " + oAuth2User.getAttributes());
            UserEntity userEntityFromOauth2 = oAuth2UserToUserEntity(oAuth2User);
            userEntity = this.getUserFromEmail(userEntityFromOauth2.getEmail());
        }
        return userEntity;
    }

    public UserEntity getUserFromEmail(String email) {
        return userRepository.findByEmail(email).stream().findFirst().get();
    }

}
