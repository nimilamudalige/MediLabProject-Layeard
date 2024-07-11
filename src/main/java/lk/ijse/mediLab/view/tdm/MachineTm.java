package lk.ijse.mediLab.view.tdm;

import javafx.fxml.FXML;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MachineTm {

    @FXML
    private String id;
    @FXML
    private String name;
    @FXML
    private String des;
}
