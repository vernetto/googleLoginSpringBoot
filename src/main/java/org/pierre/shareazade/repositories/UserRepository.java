package org.pierre.shareazade.repositories;

import org.pierre.shareazade.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
