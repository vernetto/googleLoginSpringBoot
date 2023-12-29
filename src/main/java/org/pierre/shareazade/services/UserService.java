package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.repositories.UserRepository;
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

    public UserEntity getCurrentUserDetails() {
        UserEntity userEntity = userRepository.findById(1L).get();
        log.info("userEntity: {}", userEntity);
        return userEntity;
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

    public void createNewUserWhenNeeded(OAuth2User oAuth2User) {
        UserDTO userDTO = oAuth2UserToUserDTO(oAuth2User);
        List<UserEntity> users = userRepository.findByEmail(userDTO.getEmail());
        log.info("users = {} " , users);
        if (users.isEmpty()) {
            UserEntity newUserEntity = new UserEntity();
            newUserEntity.setEmail(userDTO.getEmail());
            newUserEntity.setTelephone("");
            newUserEntity.setName(userDTO.getName());
            newUserEntity.setPicture(userDTO.getPicture());
            log.info("creating user = {} " , newUserEntity);
            userRepository.save(newUserEntity);
        }

    }

    public UserDTO oAuth2UserToUserDTO(OAuth2User oAuth2User) {
        String name = (String)(oAuth2User.getAttributes().get("name"));
        String picture = (String)(oAuth2User.getAttributes().get("picture"));
        String email = (String)(oAuth2User.getAttributes().get("email"));
        UserDTO userDTO = new UserDTO(0L, name, "", email, picture);
        return userDTO;
    }


}
