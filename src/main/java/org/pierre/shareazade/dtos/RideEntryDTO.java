package org.pierre.shareazade.dtos;

import lombok.Data;
import org.pierre.shareazade.constants.RideType;

import java.util.Date;

@Data
public class RideEntryDTO {
    private Long id;
    private Date rideDate;
    private String rideTime;
    private RideType rideType;
    private String rideComment;
    private UserDTO user;
    private CityDTO fromCity;
    private CityDTO toCity;
}
