package lk.ijse.mediLab.entity;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

        @FXML
        private String PaymentId;
        @FXML
        private Date Date;
        @FXML
        private Double Amount;




}




