package lk.ijse.mediLab.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DashboardFormController {
    public AnchorPane rootNode;
    public JFXButton btnmachine;
    public JFXButton btnEmployee;
    public JFXButton btnBack;
    public JFXButton btnpayment;
    public JFXButton btnMR;
    public JFXButton btnclient;
    public JFXButton btnAppointment;
    public Label lblDate;


    public void initialize() {
        setDate();
    }

    private void setDate() {
        LocalDate localDate = LocalDate.now();
        lblDate.setText(localDate.toString());
    }

    public void btnCheckUpOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Appoinment_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Appointment Form");
        stage.centerOnScreen();
    }

    public void btnClientOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/client_form.fxml"));
            Stage stage = (Stage) rootNode.getScene().getWindow();

            stage.setScene(new Scene(anchorPane));
            stage.setTitle("Client Form");
            stage.centerOnScreen();
        }



    public void btnMROnAction(ActionEvent actionEvent) throws IOException {
       AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/medical_report_form.fxml"));
       Stage stage = (Stage) rootNode.getScene().getWindow();
       stage.setScene(new Scene(anchorPane));
       stage.setTitle("Medical Form");
       stage.centerOnScreen();

    }

    public void btnPaymentOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/payment_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("login Form");
        stage.centerOnScreen();

    }


    public void btnbackOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("login Form");
        stage.centerOnScreen();
    }

    public void btnMachineOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/machine_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Machine Form");
        stage.centerOnScreen();

    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/employee_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();

    }
}
