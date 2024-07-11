package lk.ijse.mediLab.view.tdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartTm {
    private String colCartId;
    private Date colCartDate;
    private Time colCartTime;
    private String colCheckId;
    private double colCheckUp;


  /*  public CartTm(String id, String type, double price, double total) {
        this.colCartId = id;
        this.colCartDate = type;
        this.colCartTime = String.valueOf(price);
        this.colCheckUp = String.valueOf(total);

   */
    }

