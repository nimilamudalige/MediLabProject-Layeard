package lk.ijse.mediLab.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.mediLab.dao.custom.CheckUpDAO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.impl.CheckUpDAOImpl;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dto.CheckUpDTO;
import lk.ijse.mediLab.dto.ClientDTO;
import lk.ijse.mediLab.view.tdm.CheckUpTm;
import lk.ijse.mediLab.view.tdm.CustomerTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewCheckUpFormController {

    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXButton btnCheckUpAdd;
    public TextField txtType;
    public TextField txtPrice;
    public TextField txtId;
    public TableColumn<?, ?> colPrice;
    public TableColumn<?, ?> colType;
    public TableColumn<?, ?> colId;
    public TableView tblCheckup;
    public AnchorPane rootNode;

    CheckUpDAO checkUpDAO = new CheckUpDAOImpl();


    public void initialize() throws SQLException {
        setCellValueFactory();
        loadAllCheckUp();
    }

    private void loadAllCheckUp() throws SQLException {
        try {
            CheckUpDAOImpl checkUpDAO = new CheckUpDAOImpl();
            ArrayList<CheckUpDTO> checkUpDTOArrayList = checkUpDAO.getAll();
            for (CheckUpDTO checkUPDTO : checkUpDTOArrayList) {
                tblCheckup.getItems().add(new CheckUpTm(checkUPDTO.getCheckId(), checkUPDTO.getType(), checkUPDTO.getPrice()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("colId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("colType"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("colPrice"));
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String type = txtType.getText();
        double price = Double.parseDouble(txtPrice.getText());
        CheckUpDTO dto = new CheckUpDTO(id, type, price);
        boolean isAdded = false;
        try {
            isAdded = checkUpDAO.update(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Client Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        boolean isDeleted = false;
        try {
            isDeleted = checkUpDAO.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "CheckUp deleted!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "CheckUp not deleted!").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnCheckUpAddOnAction(ActionEvent actionEvent){
        String id = txtId.getText();
        String type = txtType.getText();
        double price = Double.parseDouble(txtPrice.getText());

        CheckUpDTO dto = new CheckUpDTO(id, type, price);
        boolean isAdded = false;
        try {
            isAdded = checkUpDAO.save(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "CheckUp added!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "CheckUp not added!").show();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

