package lk.ijse.mediLab.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.PaymentBO;
import lk.ijse.mediLab.dto.PaymentDTO;
import lk.ijse.mediLab.entity.Payment;
import lk.ijse.mediLab.view.tdm.PaymentTm;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentFormController {
  
    public JFXButton btnPymentDelete;
    public JFXButton btnPaymentUpdate;
    public JFXButton btnPaymentAdd;
    public TableColumn<?,?> colId;
    public TableColumn<?,?> coiDate;
    public TableColumn<?,?> colAmount;
    public TableView tblPayment;
    public JFXButton btnbackUpdate;

    public AnchorPane rootNode;
    public TextField txtPaymentId;

    public TextField txtAmount;
    public Label lblDate;
    PaymentBO paymentBO  = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);


    public void initialize() throws SQLException {

        setCellValueFactory();
        loadAllPayments();
        setDate();
    }

    private void loadAllPayments() throws SQLException {
        try {
            ArrayList<PaymentDTO> allCustomers = paymentBO.getAllPayments();

            for (PaymentDTO pm : allCustomers) {
                tblPayment.getItems().add(new PaymentTm(pm.getPaymentId(), pm.getDate(), pm.getAmount()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {

        colId.setCellValueFactory(new PropertyValueFactory<>("PaymentId"));
        coiDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
    }

    public void setDate() {

        LocalDate localDate = LocalDate.now();
        lblDate.setText(localDate.toString());
    }

    public void btnPaymentDeleteOnAction(ActionEvent actionEvent) {
        String id = txtPaymentId.getText();
        try {
            boolean isDeleted = paymentBO.deletePayment(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Deleted").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void btnpaymentUpdstrOnAction(ActionEvent actionEvent) {

        String id = txtPaymentId.getText();
        String amount = txtAmount.getText();
        PaymentDTO paymentDTO = new PaymentDTO(id, Date.valueOf(lblDate.getText()), Double.valueOf(amount));
        boolean isUpdated = false;
        try {
            isUpdated = paymentBO.updatePayment(paymentDTO);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Updated").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnPamentAddOnAction(ActionEvent actionEvent) {
        String paymentId = txtPaymentId.getText();
        Double amount = Double.valueOf(txtAmount.getText());

        PaymentDTO paymentDTO = new PaymentDTO(paymentId, Date.valueOf(lblDate.getText()), amount);
        boolean isAdded = false;
        try {
            isAdded = paymentBO.savePayment(paymentDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public void btnBackPaymentOnAction(ActionEvent actionEvent) throws IOException {

            AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
            Scene scene = new Scene(rootNode);

            Stage stage = (Stage) this.rootNode.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Dashboard Form");
    }
}
