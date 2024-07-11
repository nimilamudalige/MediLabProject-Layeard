package lk.ijse.mediLab.entity;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckUp {
    @FXML
    private String checkId;
    @FXML
    private String type;
    @FXML
    private double price;

}
