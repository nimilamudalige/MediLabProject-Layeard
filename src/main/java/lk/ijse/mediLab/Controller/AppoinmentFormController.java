package lk.ijse.mediLab.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.mediLab.DB.DbConnection;
import lk.ijse.mediLab.bo.BOFactory;
import lk.ijse.mediLab.bo.custom.AppointmentBO;
import lk.ijse.mediLab.bo.custom.CheckUpBO;
import lk.ijse.mediLab.bo.custom.ClientBO;
import lk.ijse.mediLab.bo.custom.PaymentBO;
import lk.ijse.mediLab.dao.custom.AppointmentDAO;
import lk.ijse.mediLab.dao.custom.CheckUpDAO;
import lk.ijse.mediLab.dao.custom.ClientDAO;
import lk.ijse.mediLab.dao.custom.PaymentDAO;
import lk.ijse.mediLab.dao.custom.impl.AppointmentDAOImpl;
import lk.ijse.mediLab.dao.custom.impl.CheckUpDAOImpl;
import lk.ijse.mediLab.dao.custom.impl.ClientDAOImpl;
import lk.ijse.mediLab.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.mediLab.dto.AppointmentDTO;
import lk.ijse.mediLab.dto.CheckUpAppointmentDetail;
import lk.ijse.mediLab.dto.ClientDTO;
import lk.ijse.mediLab.dto.PaymentDTO;
import lk.ijse.mediLab.entity.CheckUp;
import lk.ijse.mediLab.entity.Client;
import lk.ijse.mediLab.view.tdm.CartTm;
import lk.ijse.mediLab.view.tdm.AppointmentTm;
import lk.ijse.mediLab.view.tdm.CustomerTm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppoinmentFormController {
    public AnchorPane rootNode;
    public Label lblCID;
    public Label lblCName;
    public TableView tblCart;
    public TableColumn<?, ?> colCartId;
    public TableColumn<?, ?> colCartDate;
    public TableColumn<?, ?> colCartTime;
    public TableColumn<?, ?> colCheckUp;
    public Label LblTotal;
    public Label lblCheckId;
    public Label lblAppointmentId;
    public Label lblPaymentId;

    public TableColumn<?, ?> colCheckId;
    @FXML
    private DatePicker DPicker;

    @FXML
    private Label LblPrice;

    @FXML
    private Label Lbltotal;

    @FXML
    private JFXButton btnAddtoCart;

    @FXML
    private JFXButton btnAppointmentAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnbackUpdate;

    @FXML
    private JFXButton btnview;

    @FXML
    private JFXButton btnview1;

    @FXML
    private JFXComboBox<String> cmbCheck;

    @FXML
    private TableColumn<?, ?> colClientId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private Label lblDate;


    @FXML
    private TableView<?> tblAppointment;

    @FXML
    private TextField txtId1;

    @FXML
    private TextField txtPaymentId;

    @FXML
    private TextField txtTime;

    @FXML
    private TextField txtTime1;

    @FXML
    private TextField txtType1;

    private String LblNetTotal = String.valueOf(0);
    private ObservableList<CartTm> cartList = FXCollections.observableArrayList();
   // AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
 //   PaymentDAO paymentDAO = new PaymentDAOImpl();
 //   ClientDAO clientDAO = new ClientDAOImpl();

   // CheckUpDAO checkUpDAO = new CheckUpDAOImpl();
   ClientBO clientBO  = (ClientBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CLIENT);
    AppointmentBO appointmentBO  = (AppointmentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.APPOINTMENT);
    CheckUpBO checkUpBO  = (CheckUpBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHECKUP);
    PaymentBO paymentBO  = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PAYMENT);





    public void initialize() throws SQLException {
        setDate();
        setCellValueFactory();
        loardAllAppoinment();
        loardAllCheckUptest();
        loardNextAppointmentId();
        loardNextPaymentId();
    }

    private void loardAllCheckUptest() throws SQLException {
        List<String> checkUps = checkUpBO.getChrckUptest();
        ObservableList obList = FXCollections.observableArrayList(checkUps);
        cmbCheck.setItems(obList);
    }

    private void setDate() {

        LocalDate localDate = LocalDate.now();
        lblDate.setText(localDate.toString());
    }

    private void loardAllAppoinment() throws SQLException {
        tblAppointment.getItems().clear();
        try {
            AppointmentDAOImpl appointmentDAO=new AppointmentDAOImpl();
            ArrayList<AppointmentDTO> appointmentDTOArrayList=appointmentDAO.getAll();
            for (AppointmentDTO appointmentDTO:appointmentDTOArrayList) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colClientId.setCellValueFactory(new PropertyValueFactory<>("ClientId"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("PaymentId"));
        colCartId.setCellValueFactory(new PropertyValueFactory<>("colCartId"));
        colCartDate.setCellValueFactory(new PropertyValueFactory<>("colCartDate"));
        colCartTime.setCellValueFactory(new PropertyValueFactory<>("colCartTime"));
        colCheckId.setCellValueFactory(new PropertyValueFactory<>("colCheckId"));
        colCheckUp.setCellValueFactory(new PropertyValueFactory<>("colCheckUp"));
    }

    public void btnBackClientOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Appointment Form");
        stage.centerOnScreen();
    }


    public void veiwCheckUpOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/viewCheckUp_form.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Add client Form");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnAppointmentAddOnAction(ActionEvent actionEvent) throws SQLException {
        String id = lblAppointmentId.getText();
        String type = txtType1.getText();
        Date date = Date.valueOf(DPicker.getValue());
        Time time = Time.valueOf(txtTime.getText());
        String clientId = lblCID.getText();
        String paymentId = lblPaymentId.getText();
        String CheckId = lblCheckId.getText();
        double NetTotal = Double.parseDouble(String.valueOf(Double.parseDouble(LblNetTotal)));
        double price = Double.parseDouble(LblPrice.getText());

        PaymentDTO dto = new PaymentDTO(paymentId,date,price);
        boolean isAdded = false;
        try {
            isAdded = paymentBO.savePayment(dto);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        } catch (SQLException e) {
            new RuntimeException(e);
        }

        AppointmentDTO appointment = new AppointmentDTO(id, type, date, time, clientId, paymentId);
        boolean isAdded1 = false;
        try {
            isAdded1 = appointmentBO.saveAppointment(appointment);
            if (isAdded1) {
                new Alert(Alert.AlertType.CONFIRMATION, "Appointment Added").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        /*  List<CheckUpAppointmentDetail> checkUpAppointmentDetails = new ArrayList<>();
        for (int i = 0; i < tblCart.getItems().size(); i++) {
            CartTm cartTm = cartList.get(i);
            CheckUpAppointmentDetail checkUpAppointmentDetail = new CheckUpAppointmentDetail(id, cartTm.getColCheckId(), price);
            checkUpAppointmentDetails.add(checkUpAppointmentDetail);

            try {
                boolean isAdded2 = AppointmentRepo.AddNewAppoinment(checkUpAppointmentDetail);
                if (isAdded2) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Appointment Added").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

       */

        List<CheckUpAppointmentDetail> checkUpAppointmentDetails = new ArrayList<>();
        System.out.println(cartList.size());
        for (CartTm cartTm : cartList) {
            CheckUpAppointmentDetail checkUpAppointmentDetail = new CheckUpAppointmentDetail(id, cartTm.getColCheckId(), price);
            checkUpAppointmentDetails.add(checkUpAppointmentDetail);
            System.out.println("check2");
            try {
                boolean isAdded2 = AppointmentDAOImpl.AddNewAppoinment(checkUpAppointmentDetail);
                if (isAdded2) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Appointment Added").show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something went wrong").show();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        }



        public void btnAddToCartOnAction(ActionEvent actionEvent) {
        String id = lblAppointmentId.getText();
        Date date = Date.valueOf(DPicker.getValue());
        Time time = Time.valueOf(txtTime.getText());
        String checkId = lblCheckId.getText();
        double price = Double.parseDouble(LblPrice.getText());
        boolean add = tblCart.getItems().add(new CartTm(id, date, time, checkId, price));

        cartList.add(new CartTm(id,date,time,checkId,price));
        calculateNetTotal();
        LblNetTotal = String.valueOf(Double.parseDouble(LblNetTotal) + price);
        String CheckId = lblCheckId.getText();



        }
        public void calculateNetTotal() {
        double total = 0;
        for (int i = 0; i < tblCart.getItems().size(); i++) {
            total += (double) colCheckUp.getCellData(i);
        }
        LblTotal.setText(String.valueOf(total));
    }

    public void cmbCheckUpOnAction(ActionEvent actionEvent) {
        String checkUp = cmbCheck.getValue();
        try {
            CheckUp checkUp1 = checkUpBO.SearchByTypeCheck(checkUp);
            LblPrice.setText(String.valueOf(checkUp1.getPrice()));
            lblCheckId.setText(checkUp1.getCheckId());

            System.out.println("checkUp1 = " + checkUp1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnLoardDetailOnAction(ActionEvent actionEvent) {
        String contact = txtTime1.getText();
        try {
            ClientDTO clientDTO = clientBO.SearchBycontact(contact);
            lblCName.setText(clientDTO.getName());
            lblCID.setText(clientDTO.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnAddCOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/addClient_form.fxml"));
        Stage stage = new Stage();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Add client Form");
        stage.centerOnScreen();
        stage.show();
    }

    private void loardNextAppointmentId() {
        try {
            String currentId1 = appointmentBO.currentId();
            String nextId = nextId(currentId1);

            lblAppointmentId.setText(nextId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private String nextId(String currentAppointmentId) {
        if (currentAppointmentId != null) {
            String[] split = currentAppointmentId.split("A");
            int selectedId = Integer.parseInt(split[1]);

            if (selectedId < 9) {
                selectedId++;
                return "A00" + selectedId;
            } else if (selectedId < 99) {
                selectedId++;
                return "A0" + selectedId;
            } else {
                selectedId++;
                return "A" + selectedId;
            }
        }


        return "A001";
    }

    private void loardNextPaymentId() {
        try {
            String currentId2 = paymentBO.currentId2();
            String nextId2 = nextId2(currentId2);

            lblPaymentId.setText(nextId2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String nextId2(String currentPaymentId) {
        if (currentPaymentId != null) {
            String[] split = currentPaymentId.split("P");
            int selectedId = Integer.parseInt(split[1]);

            if (selectedId < 9) {
                selectedId++;
                return "P00" + selectedId;
            } else if (selectedId < 99) {
                selectedId++;
                return "P0" + selectedId;
            } else {
                selectedId++;
                return "P" + selectedId;

            }
        }
        return "P001";
    }

    public void btnPrintBillOnAction(ActionEvent actionEvent) throws JRException, SQLException {
        JasperDesign jasperDesign =
                JRXmlLoader.load("src/main/resources/reports/medilab.jrxml");
        JasperReport jasperReport =
                JasperCompileManager.compileReport(jasperDesign);

        Map<String, Object> data = new HashMap<>();
        data.put("OrderID",lblAppointmentId.getLabelFor());

        JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                        jasperReport,
                        data,
                        DbConnection.getInstance().getConnection());

        JasperViewer.viewReport(jasperPrint,false);
    }
}
