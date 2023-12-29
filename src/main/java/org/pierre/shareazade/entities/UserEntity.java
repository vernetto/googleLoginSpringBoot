package org.pierre.shareazade.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(generator="user_seq")
    @SequenceGenerator(name="user_seq",sequenceName="USER_SEQ", allocationSize=1, initialValue = 1)
    private Long id;

    @Column(length = 100, nullable = false)
    private String fullName;

    @Column(length = 20, nullable = false)
    private String telephone;

    @Column(length = 50, nullable = false)
    private String email;

}
