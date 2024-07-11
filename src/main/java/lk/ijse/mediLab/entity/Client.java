package lk.ijse.mediLab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    private String id;
    private String name;
    private int age;
    private String address;
    private String tel;

    private String email;
    private String UserId;

}


