package lk.ijse.mediLab.entity;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Machine {

    @FXML
    private String id;
    @FXML
    private String name;
    @FXML
    private String des;
}
