package lk.ijse.mediLab.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dto.ClientDTO;
import lk.ijse.mediLab.view.tdm.CustomerTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientFormController {

        public AnchorPane rootNode;
        public TableColumn<?,?> colUserId;
        public TableColumn<?,?> colTel;
        public TableColumn<?,?> colAdd;
        public TableColumn<?,?> colAge;
        public TableColumn<?,?> colName;
        public TableColumn<?,?> colId;
        public TableView<CustomerTm> tblCustomer;
        public TableColumn<?,?> colEmail;
        ClientDAO clientDAO = new ClientDAOImpl();



    public void initialize(){

            setCellValueFactory();
            loadAllCustomers();
        }

        private void loadAllCustomers() {
            tblCustomer.getItems().clear();
            try {
                   ClientDAOImpl clientDAO=new ClientDAOImpl();
                   ArrayList<ClientDTO> clientDTOArrayList=clientDAO.getAll();
                   for (ClientDTO clientDTO:clientDTOArrayList) {
                        tblCustomer.getItems().add(new CustomerTm(clientDTO.getId(), clientDTO.getName(),clientDTO.getAge(),clientDTO.getAddress(),clientDTO.getTel(),clientDTO.getEmail(),clientDTO.getUserId()));
                    }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private void setCellValueFactory() {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
            colAdd.setCellValueFactory(new PropertyValueFactory<>("address"));
            colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        }
        public void btnAddClientOnAction(ActionEvent actionEvent) throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/addClient_form.fxml"));
            Stage stage = new Stage();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Add client Form");
            stage.centerOnScreen();
            stage.show();
        }

        public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/updateClient_form.fxml"));
            Stage stage = new Stage();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Add client Form");
            stage.centerOnScreen();
            stage.show();

        }
        public  void btnBackClientOnAction(ActionEvent actionEvent) throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
            Stage stage = (Stage) rootNode.getScene().getWindow();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Dashboard Form");
            stage.centerOnScreen();

        }
}





