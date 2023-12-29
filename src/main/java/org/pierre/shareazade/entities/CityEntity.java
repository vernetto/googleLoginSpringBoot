package org.pierre.shareazade.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CityEntity {
    @Id
    @GeneratedValue(generator="city_seq")
    @SequenceGenerator(name="city_seq",sequenceName="CITY_SEQ", allocationSize=1, initialValue = 1)
    private Long id;

    @Column(length = 100, nullable = false)
    private String cityName;

}
