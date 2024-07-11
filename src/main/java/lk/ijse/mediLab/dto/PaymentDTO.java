package lk.ijse.mediLab.dto;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {

        @FXML
        private String PaymentId;
        @FXML
        private Date Date;
        @FXML
        private Double Amount;




}




