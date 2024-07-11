package lk.ijse.mediLab.bo.custom.impl;

import lk.ijse.mediLab.bo.custom.AppointmentBO;
import lk.ijse.mediLab.dao.DAOFactory;
import lk.ijse.mediLab.dao.custom.AppointmentDAO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dto.AppointmentDTO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.entity.Appointment;
import lk.ijse.mediLab.entity.CheckUp;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentBOImpl implements AppointmentBO {
    AppointmentDAO appointmentDAO = (AppointmentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.APPOINTMENT);
    ClientDAO clientDAO = (ClientDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CLIENT);



    @Override
    public ArrayList<AppointmentDTO> getAllAppointments() throws SQLException {
        ArrayList<AppointmentDTO> allAppointments = new ArrayList<>();
        ArrayList<Appointment> all = appointmentDAO.getAll();
        for (Appointment appointment : all) {
            allAppointments.add(new AppointmentDTO(appointment.getId(), appointment.getType(), appointment.getDate(), appointment.getTime(), appointment.getClientId(), appointment.getPaymentId()));
        }
        return allAppointments;
    }

    @Override
    public boolean saveAppointment(AppointmentDTO dto) throws SQLException {
        return clientDAO.save(new Appointment(dto.getId(), dto.getType(), dto.getDate(), dto.getTime(), dto.getClientId(), dto.getPaymentId()));
    }

    @Override
    public boolean updateAppointment(AppointmentDTO entity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteAppointment(String id) throws SQLException {
        return false;
    }
    public String currentId() throws SQLException {
        return null;
    }
}
