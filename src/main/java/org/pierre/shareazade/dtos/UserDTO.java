package org.pierre.shareazade.dtos;


import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String telephone;
    private String email;
    private String pictureUrl;
}
