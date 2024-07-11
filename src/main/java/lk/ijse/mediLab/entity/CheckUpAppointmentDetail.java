package lk.ijse.mediLab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CheckUpAppointmentDetail {

    private String AppoinmentId;
    private String checkId;
    private double chekUpPrice;
}
