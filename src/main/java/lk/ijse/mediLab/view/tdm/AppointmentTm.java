package lk.ijse.mediLab.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AppointmentTm {

    private String id;
    private String type;
    private Date date;
    private Time time;
    private String clientId;
    private String paymentId;


}


