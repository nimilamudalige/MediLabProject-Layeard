package lk.ijse.mediLab.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.ClientBO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dto.ClientDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class AddClientFormController {
    public AnchorPane rootNode1;
    public TextField txtAdd;
    public TextField txtTel;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtUser;
    public Label lblClientId;
    public TextField txtEmail;

  //  ClientDAO clientDAO = new ClientDAOImpl();
  ClientBO clientBO  = (ClientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CLIENT);


    public void initialize() {
        loardNextClientId();
    }

    public void btnBackAddClientOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/client_form.fxml"));
        Stage stage = (Stage) rootNode1.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }


    public void btnClearClientOnaction(ActionEvent actionEvent) {


        txtName.clear();
        txtAge.clear();
        txtAdd.clear();
        txtTel.clear();
        txtEmail.clear();
        txtUser.clear();

    }

    public void btnClientAddOnAction(ActionEvent actionEvent) {
//
        String Id = lblClientId.getText();
        String Name = txtName.getText();
        int Age = Integer.parseInt(txtAge.getText());
        String Add = txtAdd.getText();
        String Tel = txtTel.getText();
        String email = txtEmail.getText();
        String UserId = txtUser.getText();

        ClientDTO dto = new ClientDTO(Id, Name, Age, Add, Tel, email, UserId);
        boolean isAdded = false;
        try {
         isAdded = clientBO.saveClient(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Client Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loardNextClientId() {
        try {
            String currentId = clientBO.currentId1();
            String nextId = nextId(currentId);

            lblClientId.setText(nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String nextId(String currentCustomerId) {

        if (currentCustomerId != null) {
            String[] split = currentCustomerId.split("C");
            int selectedId = Integer.parseInt(split[1]);

            if (selectedId < 9) {
                selectedId++;
                return "C00" + selectedId;
            } else if (selectedId < 99) {
                selectedId++;
                return "C0" + selectedId;
            } else {
                selectedId++;
                return "C" + selectedId;
            }
        }


        return "C001";
    }

    private void removeError(TextField textField) {
        textField.setStyle("-fx-border-color: green");
    }


    private void addError(TextField textField) {
        textField.setStyle("-fx-border-color: red");
    }




    public void txtnameReleasedOnAcrtion(KeyEvent keyEvent) {
        Pattern namePattern = Pattern.compile(("^([A-Za-z]{2,})$"));
        if (!namePattern.matcher(txtName.getText()).matches()) {
            addError(txtName);
        } else {
            removeError(txtName);
        }

    }

    public void ContactOnKeyRelesedOnAction(KeyEvent keyEvent) {
        Pattern telPattern = Pattern.compile(("^([0-9]{10})$"));
        if (!telPattern.matcher(txtTel.getText()).matches()) {
            addError(txtTel);
        } else {
            removeError(txtTel);
        }
    }

    public void addOnKeyRelesedOnAction(KeyEvent keyEvent) {
        Pattern addressPattern = Pattern.compile(("^([A-Za-z0-9]{3,})$"));
        if (!addressPattern.matcher(txtAdd.getText()).matches()) {
            addError(txtAdd);
        } else {
            removeError(txtAdd);
        }
    }
    
    public void AgeOnKeyReleasedOnAction(KeyEvent keyEvent){
        
    }

    public void EmailOnKeyReleleasedOnAction(KeyEvent keyEvent) {
        Pattern emailPattern = Pattern.compile(("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$"));
        if (!emailPattern.matcher(txtEmail.getText()).matches()) {
            addError(txtEmail);
        } else {
            removeError(txtEmail);
        }
    }
}







