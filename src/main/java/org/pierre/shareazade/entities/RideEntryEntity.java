package org.pierre.shareazade.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.pierre.shareazade.constants.RideType;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Data
public class RideEntryEntity {
    @Id
    @GeneratedValue(generator="rideentry_seq")
    @SequenceGenerator(name="rideentry_seq",sequenceName="RIDEENTRY_SEQ", allocationSize=1, initialValue = 1)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date rideDate;

    @Column(length = 5, nullable = false)
    private String rideTime;

    @Enumerated(EnumType.STRING)
    private RideType rideType;

    @Column(length = 100, nullable = true)
    private String rideComment;

    @ManyToOne
    private UserEntity userEntity;

    @ManyToOne
    private CityEntity fromCity;

    @ManyToOne
    private CityEntity toCity;

    public String getFormattedDate() {
        // Formatter for the "2023-10-21" part
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");

        // Formatter for the "October 21 Friday" part
        SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM dd EEEE");

        // Formatting the date
        String formattedDate = formatter1.format(getRideDate()) + ", " + formatter2.format(getRideDate());
        return formattedDate;

    }

}
