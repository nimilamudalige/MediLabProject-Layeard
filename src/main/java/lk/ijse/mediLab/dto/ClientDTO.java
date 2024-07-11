package lk.ijse.mediLab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDTO {
    private String id;
    private String name;
    private int age;
    private String address;
    private String tel;

    private String email;
    private String UserId;

}


