package lk.ijse.mediLab.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.ClientBO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dto.ClientDTO;


import java.io.IOException;
import java.sql.SQLException;

public class UpdateClientFormController {



    public TextField txtTel;
    public TextField txtAdd;
    public TextField txtName;
    public TextField txtId;
    public AnchorPane rootNode2;
    public TextField txtUserId;
    public TextField txtAge;
    public TextField txtEmail;

 //   ClientDAO clientDAO = new ClientDAOImpl();
 ClientBO clientBO  = (ClientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CLIENT);



    public void btnDeleteClientOnAction(ActionEvent actionEvent) {

            String id = txtId.getText();

            try {
                boolean isDeleted = clientBO.deleteClient(id);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }



    public void btnBackClientOnAction(ActionEvent actionEvent) throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Client_form.fxml"));
            Stage stage = (Stage) rootNode2.getScene().getWindow();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("login Form");
            stage.centerOnScreen();
        }


    public void btnUpdateClientOnAction(ActionEvent actionEvent) {
        String Id = txtId.getText();
        String Name = txtName.getText();
        int Age = Integer.parseInt(txtAge.getText());
        String Add = txtAdd.getText();
        String Tel = txtTel.getText();
        String Email = txtEmail.getText();
        String UserId = txtUserId.getText();

        ClientDTO dto = new ClientDTO(Id,Name,Age,Add,Tel,Email,UserId);
        boolean isAdded = false;
        try {
            isAdded = clientBO.updateClient(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Client Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
