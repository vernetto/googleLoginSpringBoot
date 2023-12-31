package org.pierre.shareazade.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(generator="user_seq")
    @SequenceGenerator(name="user_seq",sequenceName="USER_SEQ", allocationSize=1, initialValue = 1)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 20, nullable = true)
    private String telephone;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 150, nullable = true)
    private String picture;

}
