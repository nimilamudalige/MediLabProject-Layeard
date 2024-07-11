package lk.ijse.mediLab.dto;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckUpDTO {
    @FXML
    private String checkId;
    @FXML
    private String type;
    @FXML
    private double price;

}
