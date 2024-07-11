package lk.ijse.mediLab.bo.custom;

import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBO {
    public ArrayList<PaymentDTO> getAllPayments() throws SQLException;


    public boolean savePayment(PaymentDTO dto) throws SQLException;


    public boolean updatePayment(PaymentDTO entity) throws SQLException;


    public boolean deletePayment(String id) throws SQLException;

    public String currentId2() throws SQLException;
}
