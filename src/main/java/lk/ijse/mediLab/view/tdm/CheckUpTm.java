package lk.ijse.mediLab.view.tdm;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckUpTm {
    @FXML
    private String colId;
    @FXML
    private String colType;
    @FXML
    private double colPrice;

}
