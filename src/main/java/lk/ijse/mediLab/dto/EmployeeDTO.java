package lk.ijse.mediLab.dto;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    @FXML
    private String employeeId;
    @FXML
    private String name;
    @FXML
    private String Address;
    @FXML
    private int contact;
    @FXML
    private String type;
    @FXML
    private String bId;
}
