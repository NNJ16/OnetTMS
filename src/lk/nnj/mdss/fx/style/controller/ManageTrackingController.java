package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.*;
import lk.nnj.mdss.fx.dto.ContainDTO;
import lk.nnj.mdss.fx.dto.CustomerDTO;
import lk.nnj.mdss.fx.dto.OrderDTO;
import lk.nnj.mdss.fx.dto.TrackDTO;
import org.controlsfx.control.textfield.TextFields;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ManageTrackingController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXComboBox<String> cmd_status;

    @FXML
    private TableView<ContainDTO> tbl_item;

    @FXML
    private ImageView lbl_search;

    @FXML
    private JFXTextField txt_note;

    @FXML
    private JFXComboBox<String> cmd_delby;
    @FXML
    private Label lbl_oid;
    @FXML
    private JFXDatePicker txt_date;

    @FXML
    private JFXTextField txt_tid;

    @FXML
    private ImageView lbl_back;

    @FXML
    private JFXTextField txt_cid;

    @FXML
    private JFXTextField txt_bname;

    @FXML
    private JFXTextField txt_phone;

    @FXML
    private JFXTextField txt_addr1;

    @FXML
    private JFXTextField txt_addr2;

    @FXML
    private JFXTextField txt_city;

    @FXML
    private JFXButton btn_del;

    @FXML
    private ImageView lbl_search111;

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
        try {
            ArrayList<String> itemList = ManageQueryBussines.findAllDel();
            String []items =  new String[itemList.size()];
            items = itemList.toArray(items);
            ObservableList<String> options =
                    FXCollections.observableArrayList(
                            items
                    );
            cmd_delby.setItems(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String []st = new String[]{"Delivered","Return"} ;
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        st
                );

        cmd_status.setItems(options);
    }
    @FXML
    void update(ActionEvent event) {
        Date date = null;
            String tid = txt_tid.getText();
            try {
                date = Date.valueOf(txt_date.getValue());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Please enter Date.");
            }
            String sts = cmd_status.getValue();
            String note = txt_note.getText();
            String delby = cmd_delby.getValue();
            String oid = lbl_oid.getText();
            TrackDTO trackDTO =
                    new TrackDTO(
                            tid,
                            date,
                            sts,
                            note,
                            delby,
                            oid
                    );

        try {
            if(ManageTrackBussines.updateTrack(trackDTO))
            {
                JOptionPane.showMessageDialog(null,"Tracking Details Updated Successfully");
            }else
                {
                    JOptionPane.showMessageDialog(null,"Error, Cannot Update");
                }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    void search(MouseEvent event) {
        try
        {
            String tid = txt_tid.getText();
            TrackDTO trackDTO = ManageTrackBussines.findTrack(tid);
            String oid = trackDTO.getOid();
            OrderDTO orderDTO = ManageOrderBussines.findOrder(oid);
            String glno = orderDTO.getGllno();
            CustomerDTO customerDTO = ManageCusBussines.findCustomer(glno);

            txt_cid.setText(glno);
            txt_bname.setText(customerDTO.getBAname());
            txt_addr1.setText(customerDTO.getAddr1());
            txt_addr2.setText(customerDTO.getAddr2());
            txt_city.setText(customerDTO.getCity());
            txt_phone.setText(customerDTO.getPhone());
            lbl_oid.setText(orderDTO.getOid());

            try
            {
                txt_date.setValue(LOCAL_DATE(trackDTO.getDelDate().toString()));
                cmd_status.setValue(trackDTO.getStatus());
                txt_note.setText(trackDTO.getNote());
                cmd_delby.setValue(trackDTO.getDelby());
            }catch (Exception e)
            {

            }

            viewTable(oid);
        }catch (Exception e)
        {
            txt_date.setValue(null);
            cmd_delby.setValue("");
            cmd_status.setValue("");
            txt_note.setText("");
        }
    }
    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }
    @FXML
    void searchc(ActionEvent event) {
        try
        {
            String tid = txt_tid.getText();
            TrackDTO trackDTO = ManageTrackBussines.findTrack(tid);
            String oid = trackDTO.getOid();
            OrderDTO orderDTO = ManageOrderBussines.findOrder(oid);
            String glno = orderDTO.getGllno();
            CustomerDTO customerDTO = ManageCusBussines.findCustomer(glno);
            txt_cid.setText(glno);
            txt_bname.setText(customerDTO.getBAname());
            txt_addr1.setText(customerDTO.getAddr1());
            txt_addr2.setText(customerDTO.getAddr2());
            txt_city.setText(customerDTO.getCity());
            txt_phone.setText(customerDTO.getPhone());
            lbl_oid.setText(orderDTO.getOid());

            try
            {
                txt_date.setValue(LOCAL_DATE(trackDTO.getDelDate().toString()));
                cmd_status.setValue(trackDTO.getStatus());
                txt_note.setText(trackDTO.getNote());
                cmd_delby.setValue(trackDTO.getDelby());
            }catch (Exception e)
            {
                   txt_date.setValue(null);
                   cmd_delby.setValue("");
                   cmd_status.setValue("");
                   txt_note.setText("");
            }

            viewTable(oid);
        }catch (Exception e)
        {

        }


    }
    public void viewTable(String oid) {
        tbl_item.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_item.getColumns().get(1).setStyle("-fx-alignment: center");

        tbl_item.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("name")
                );
        tbl_item.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("qty")
                );

        try {
            List<ContainDTO> conDTOs =
                    ManageConBussines.getContains(oid);
            System.out.println();
            tbl_item.setItems(FXCollections.observableList(conDTOs));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
