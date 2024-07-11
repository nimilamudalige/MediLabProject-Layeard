package lk.ijse.mediLab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private String id;
    private String Type;
    private Date date;
    private Time time;
    private String clientId;
    private String PaymentId;


}