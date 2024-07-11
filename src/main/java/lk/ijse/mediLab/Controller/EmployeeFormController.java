package lk.ijse.mediLab.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.EmployeeDAO;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.mediLab.dto.EmployeeDTO;
import lk.ijse.mediLab.entity.Employee;
import lk.ijse.mediLab.view.tdm.EmployeeTm;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFormController {

    public TableColumn<?,?> colBId;
    public TableColumn<?,?> colType;
    public TableColumn<?,?> colTel;
    public TableColumn<?,?> colAddress;
    public TableColumn<?,?> colName;
    public TableColumn<?,?> colId;
    public TableView tblEmployee;
    public JFXButton btnbackEmployee;
    public TextField txtBId;
    public TextField txtTel;
    public TextField txtType;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtId;
    public AnchorPane rootNode;
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();


    public void initialize() {

        setCellValueFactory();
        loardAllEmployee();
    }

    private void loardAllEmployee() {
        try {
            ArrayList<EmployeeDTO> allEmployee = employeeDAO.getAll();
            for (EmployeeDTO emp : allEmployee) {
                tblEmployee.getItems().add(new EmployeeTm(emp.getEmployeeId(), emp.getName(), emp.getAddress(),emp.getContact(), emp.getType(),emp.getBId()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colBId.setCellValueFactory(new PropertyValueFactory<>("bId"));

    }

    public void btnBackEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }


    public void btnEmployeeAddOnAction(ActionEvent actionEvent) {
        String Id = txtId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        int Tel = Integer.parseInt(txtTel.getText());
        String Type = txtType.getText();
        String BId = txtBId.getText();

        EmployeeDTO employee = new EmployeeDTO(Id,Name,Address,Tel,Type,BId);

        boolean isAdded = false;
        try {
            isAdded = employeeDAO.save(employee);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void btnEmployeeDeleteOnAction(ActionEvent actionEvent) {
        String Id = txtId.getText();
        try {
            boolean isDeleted = employeeDAO.delete(Id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Deleted").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private boolean validateEmployee(){
        String name = txtName.getText();
        boolean isEmployeeNameValidated = name.matches("[a-zA-Z ]+");
        if(!isEmployeeNameValidated){
            new Alert(Alert.AlertType.ERROR,"Invalid Employee Name").show();
            return false;
        }
        return true;
    }

    public void btnEmployeeUpdstrOnAction(ActionEvent actionEvent) {

        String Id = txtId.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        int Tel = Integer.parseInt(txtTel.getText());
        String Type = txtType.getText();
        String BId = txtBId.getText();

        EmployeeDTO employee = new EmployeeDTO(Id,Name,Address,Tel,Type,BId);
        boolean isUpdated = false;
        try {
            isUpdated = employeeDAO.update(employee);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}

