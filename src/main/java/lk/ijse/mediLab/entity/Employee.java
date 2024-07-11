package lk.ijse.mediLab.entity;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
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
