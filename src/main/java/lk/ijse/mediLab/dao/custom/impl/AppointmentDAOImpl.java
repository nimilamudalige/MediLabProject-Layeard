package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.AppointmentDAO;
import lk.ijse.mediLab.dto.AppointmentDTO;
import lk.ijse.mediLab.dto.CheckUpAppointmentDetail;
import lk.ijse.mediLab.dto.ClientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDAOImpl implements AppointmentDAO {
    static CheckUpAppointmentDetailDAOImpl checkUpAppointmentDetailDAO = new CheckUpAppointmentDetailDAOImpl();

    public static boolean AddNewAppoinment(CheckUpAppointmentDetail checkUpAppointmentDetail) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        System.out.println("adfgh");
        try {

            boolean isAdded = checkUpAppointmentDetailDAO.Save(checkUpAppointmentDetail);
            if (isAdded) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException(e);
        }
    }


    @Override
    public ArrayList<AppointmentDTO> getAll() throws SQLException {
        ArrayList<AppointmentDTO> allAppointments = new ArrayList<>();

        ResultSet rst = SqlUtil.execute("SELECT * FROM Appoinment");

        while (rst.next()) {
            AppointmentDTO appointmentDTO = new AppointmentDTO(rst.getString("id"), rst.getString("Type"), rst.getDate("date"), rst.getTime("Time"), rst.getString("clientId"), rst.getString("paymentId"));
            allAppointments.add(appointmentDTO);
        }
        return allAppointments;
    }

    @Override
    public boolean save(AppointmentDTO dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO Appoinment VALUES(?, ?, ?, ?, ?, ?)", dto.getId(), dto.getType(), dto.getDate(), dto.getTime(), dto.getClientId(), dto.getPaymentId());
    }

    @Override
    public boolean update(AppointmentDTO entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public String currentId() throws SQLException {
        return SqlUtil.execute("SELECT AppoinmentId FROM Appoinment ORDER BY AppoinmentId DESC LIMIT 1");
    }
}