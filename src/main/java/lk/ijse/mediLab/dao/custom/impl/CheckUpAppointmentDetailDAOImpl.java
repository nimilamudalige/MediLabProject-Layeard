package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.custom.CheckUpAppointmentDetailDAO;
import lk.ijse.mediLab.dto.CheckUpAppointmentDetail;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckUpAppointmentDetailDAOImpl implements CheckUpAppointmentDetailDAO {
    public boolean Save(CheckUpAppointmentDetail checkUpAppointmentDetail) throws SQLException {
        System.out.println(checkUpAppointmentDetail);
        String sql = "INSERT INTO CheckUpAppointmentDetails VALUES(?, ? ,?)";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1, checkUpAppointmentDetail.getAppoinmentId());
        pstm.setObject(2, checkUpAppointmentDetail.getCheckId());
        pstm.setObject(3, checkUpAppointmentDetail.getChekUpPrice());

        return pstm.executeUpdate() > 0;
    }

}
