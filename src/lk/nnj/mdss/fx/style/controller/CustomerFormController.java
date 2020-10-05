package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageCusBussines;
import lk.nnj.mdss.fx.Bussines.ManageQueryBussines;
import lk.nnj.mdss.fx.Entity.Customer;
import lk.nnj.mdss.fx.Entity.Order;
import lk.nnj.mdss.fx.dto.CustomerDTO;
import lk.nnj.mdss.fx.dto.OrderDtDTO;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txt_cid;

    @FXML
    private JFXTextField txt_name;

    @FXML
    private ImageView lbl_back;

    @FXML
    private ImageView lbl_search;

    @FXML
    private JFXTextField txt_phone;

    @FXML
    private JFXTextField txt_address;

    @FXML
    private JFXTextField txt_address1;

    @FXML
    private JFXTextField txt_city;

    @FXML
    private JFXButton btn_up;

    @FXML
    private JFXButton btn_del;

    @FXML
    private ImageView lbl_back1;

    @FXML
    private ImageView lbl_back11;

    @FXML
    private TableView<CustomerDTO> tbl_with;

    @FXML
    void Delete(ActionEvent event) {
        String cid = txt_cid.getText();
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if(password.equals("Onet@123"))
            {
                try {

                        ArrayList<OrderDtDTO> orderDtDTOS= ManageQueryBussines.findAllOdtsCid(cid);
                        if(orderDtDTOS.size()==0)
                        {
                            if(ManageCusBussines.deleteCustomer(cid))
                            {
                                JOptionPane.showMessageDialog(null,"Customer Deleted Successfully");
                                viewTable();
                                reset();
                            }else
                            {
                                JOptionPane.showMessageDialog(null,"Error, Cannot Deleted");
                            }
                        }else
                            {
                                JOptionPane.showMessageDialog(null,"Error Cannot delete, Delete all orders related to this Customer before deleting");
                            }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }else
                {
                    JOptionPane.showMessageDialog(null,"Entered Password is not Correct");
                }
        }
    }

    @FXML
    void Update(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
        String cid = txt_cid.getText();
        String name = txt_name.getText();
        String phone = txt_phone.getText();
        String addr1 = txt_address.getText();
        String addr2 = txt_address.getText();
        String city =txt_city.getText();

        CustomerDTO customerDTO =
                new CustomerDTO(
                        cid,
                        name,
                        phone,
                        addr1,
                        addr2,
                        city
                );

        try {
            if(ManageCusBussines.updateCustomer(customerDTO))
            {
                JOptionPane.showMessageDialog(null,"Customer Updated Successfully");
                viewTable();
                reset();
            }else
                {
                    JOptionPane.showMessageDialog(null,"Error, Cannot Update");
                }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
            }else
            {
                JOptionPane.showMessageDialog(null,"Entered Password is not Correct");
            }
        }
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/AdminPanel.fxml"));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
    }

    @FXML
    void click(MouseEvent event) {
        ArrayList<CustomerDTO> cus = new ArrayList<>(tbl_with.getSelectionModel().getSelectedItems());
        for(
                CustomerDTO cusDTO:cus)

        {
            txt_cid.setText(cusDTO.getGlno());
            txt_name.setText(cusDTO.getBAname());
            txt_phone.setText(cusDTO.getPhone());
            txt_address.setText(cusDTO.getAddr1());
            txt_address1.setText(cusDTO.getAddr2());
            txt_city.setText(cusDTO.getCity());
        }
    }

    @FXML
    void search(MouseEvent event) throws Exception {
        String cid = txt_cid.getText();
        CustomerDTO customerDTO = ManageCusBussines.findCustomer(cid);
        txt_name.setText(customerDTO.getBAname());
        txt_phone.setText(customerDTO.getPhone());
        txt_address.setText(customerDTO.getAddr1());
        txt_address1.setText(customerDTO.getAddr2());
        txt_city.setText(customerDTO.getCity());
    }

    @FXML
    void searchc(ActionEvent event) throws Exception {
        String cid = txt_cid.getText();
        CustomerDTO customerDTO = ManageCusBussines.findCustomer(cid);
        txt_name.setText(customerDTO.getBAname());
        txt_phone.setText(customerDTO.getPhone());
        txt_address.setText(customerDTO.getAddr1());
        txt_address1.setText(customerDTO.getAddr2());
        txt_city.setText(customerDTO.getCity());
    }

    public void viewTable() {
        tbl_with.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(5).setStyle("-fx-alignment: center");

        tbl_with.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_with.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("BAname")
                );
        tbl_with.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("phone")
                );
        tbl_with.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("addr1")
                );
        tbl_with.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("addr2")
                );
        tbl_with.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );

        try {
            List<CustomerDTO> cusDTOS =
                    ManageCusBussines.getCustomers();
            tbl_with.setItems(FXCollections.observableList(cusDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reset()
    {
        txt_cid.setText("");
        txt_name.setText("");
        txt_phone.setText("");
        txt_address.setText("");
        txt_address1.setText("");
        txt_city.setText("");
    }
}
