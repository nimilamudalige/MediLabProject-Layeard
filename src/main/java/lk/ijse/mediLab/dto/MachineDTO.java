package lk.ijse.mediLab.dto;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MachineDTO {

    @FXML
    private String id;
    @FXML
    private String name;
    @FXML
    private String des;
}
