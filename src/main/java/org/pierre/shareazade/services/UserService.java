package org.pierre.shareazade.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pierre.shareazade.dtos.UserDTO;
import org.pierre.shareazade.entities.UserEntity;
import org.pierre.shareazade.repositories.UserRepository;
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
    }
}
