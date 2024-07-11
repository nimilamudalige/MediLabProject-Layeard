package lk.ijse.mediLab.view.tdm;

import java.sql.Date;

public class PaymentTm {
    private String PaymentId;
    private Date date;
    private Double Amount;


    public PaymentTm(String PaymentId, Date Date, Double Amount) {
        this.PaymentId = PaymentId;
        this.date = Date;
        this.Amount = Amount;
    }

    public void setPaymentId(String PaymentId) {
        this.PaymentId = PaymentId;

    }

    public String getPaymentId() {
        return PaymentId;
    }

    public void setDate(Date Date) {
        this.date = Date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public Double getAmount() {
        return Amount;
    }

}


