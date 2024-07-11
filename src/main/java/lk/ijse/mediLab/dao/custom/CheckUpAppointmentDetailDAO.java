package lk.ijse.mediLab.dao.custom;

import lk.ijse.mediLab.dto.CheckUpAppointmentDetail;

import java.sql.SQLException;

public interface CheckUpAppointmentDetailDAO  {
    public boolean Save(CheckUpAppointmentDetail checkUpAppointmentDetail) throws SQLException ;
}
