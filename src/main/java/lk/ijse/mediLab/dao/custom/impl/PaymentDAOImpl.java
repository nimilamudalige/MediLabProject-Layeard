package lk.ijse.mediLab.dao.custom.impl;

import lk.ijse.mediLab.dao.SqlUtil;
import lk.ijse.mediLab.dao.custom.PaymentDAO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public ArrayList<PaymentDTO> getAll() throws SQLException {
        ArrayList<PaymentDTO> allPayments = new ArrayList<>();
        ResultSet rst = SqlUtil.execute("SELECT * FROM payment");
        while (rst.next()) {
            PaymentDTO paymentDTO = new PaymentDTO(rst.getString("paymentId"),rst.getDate("date"), rst.getDouble("amount"));
            allPayments.add(paymentDTO);
        }
        return allPayments;
    }

    @Override
    public boolean save(PaymentDTO dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO payment VALUES(?, ?, ?)", dto.getPaymentId(), dto.getDate(), dto.getAmount());
    }

    @Override
    public boolean update(PaymentDTO entity) throws SQLException {
        return SqlUtil.execute("UPDATE payment SET date=?, amount=? WHERE paymentId=?",entity.getPaymentId(),entity.getDate(),entity.getAmount());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SqlUtil.execute("DELETE FROM payment WHERE paymentId=?",id);
    }

    @Override
    public String currentId() throws SQLException {
        return SqlUtil.execute("SELECT paymentId FROM payment ORDER BY paymentId DESC LIMIT 1");
    }
}
