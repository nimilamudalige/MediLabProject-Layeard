package lk.ijse.mediLab.bo.custom.impl;

import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.PaymentBO;
import lk.ijse.mediLab.dao.custom.PaymentDAO;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.dto.PaymentDTO;
import lk.ijse.mediLab.entity.CheckUp;
import lk.ijse.mediLab.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO  = (PaymentDAO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);


    @Override
    public ArrayList<PaymentDTO> getAllPayments() throws SQLException {
        ArrayList<PaymentDTO> allPayment = new ArrayList<>();
        ArrayList<Payment> all = paymentDAO.getAll();
        for (Payment payment : all) {
            allPayment.add(new PaymentDTO(payment.getPaymentId(), payment.getDate(), payment.getAmount()));
        }
        return allPayment;
    }

    @Override
    public boolean savePayment(PaymentDTO dto) throws SQLException {
        return paymentDAO.save(new Payment(dto.getPaymentId(), dto.getDate(), dto.getAmount()));
    }

    @Override
    public boolean updatePayment(PaymentDTO entity) throws SQLException {
        return paymentDAO.update(new Payment(entity.getPaymentId(), entity.getDate(), entity.getAmount()));
    }

    @Override
    public boolean deletePayment(String id) throws SQLException {
        return paymentDAO.delete(id);
    }

    @Override
    public String currentId2() throws SQLException {
        return paymentDAO.currentId2();
    }

}
