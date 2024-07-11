package lk.ijse.mediLab.bo.custom;

import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.bo.SuperBO;
import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dto.AppointmentDTO;
import lk.ijse.mediLab.dto.CheckUpAppointmentDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AppointmentBO extends SuperBO {


    public ArrayList<AppointmentDTO> getAllAppointments() throws SQLException;


    public boolean saveAppointment(AppointmentDTO dto) throws SQLException;


    public boolean updateAppointment(AppointmentDTO entity) throws SQLException;


    public boolean deleteAppointment(String id) throws SQLException;


    public String currentId() throws SQLException;
}

