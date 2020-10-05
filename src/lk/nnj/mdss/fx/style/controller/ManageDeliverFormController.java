package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageDelBussines;
import lk.nnj.mdss.fx.Entity.Deliver;
import lk.nnj.mdss.fx.dto.DeliverDTO;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageDeliverFormController implements Initializable {
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
    private JFXButton btn_up;

    @FXML
    private JFXButton btn_del;

    @FXML
    private ImageView lbl_back1;

    @FXML
    private ImageView lbl_back11;

    @FXML
    private JFXComboBox<String> cmb_type;
    @FXML
    private TableView<DeliverDTO> tbl_with;

    @FXML
    private JFXPasswordField txt_pwd;
    @FXML
    private JFXButton btn_add;

    @FXML
    private ImageView lbl_back12;

    @FXML
    void Add(ActionEvent event) {
        String did = txt_cid.getText();
        String name = txt_name.getText();
        String phone = txt_phone.getText();
        String pwd =txt_pwd.getText();
        String type =cmb_type.getValue();

        DeliverDTO deliverDTO=
                new DeliverDTO(
                        did,
                        name,
                        phone,
                        pwd,
                        type
                );

        try {
            if(did.equals("") || name.equals("") || phone.equals("") || pwd.equals("") || type.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Required One or More Field is Empty");
            }else {
                if(ManageDelBussines.addDeliver(deliverDTO))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    viewTable();
                    reset();
                }else
                    {
                        JOptionPane.showMessageDialog(null,"ID no already exist");
                    }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    @FXML
    void Delete(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
                String did = txt_cid.getText();
                try {
                    if(ManageDelBussines.deleteDeliver(did))
                    {
                        JOptionPane.showMessageDialog(null, "Deleted SuccessFully");
                        viewTable();
                        reset();
                    }else
                        {
                            JOptionPane.showMessageDialog(null, "Error, Cannot Deleted");
                        }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
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
        String did = txt_cid.getText();
        String name = txt_name.getText();
        String phone = txt_phone.getText();
        String pwd =txt_pwd.getText();
        String type =cmb_type.getValue();

        DeliverDTO deliverDTO=
                new DeliverDTO(
                        did,
                        name,
                        phone,
                        pwd,
                        type
                );

        try {
            if(did.equals("") || name.equals("") || phone.equals("") || pwd.equals("") || type.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Required One or More Field is Empty");
            }else {
                if(ManageDelBussines.updateDeliver(deliverDTO)){
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    viewTable();
                    reset();
                }else
                    {
                        JOptionPane.showMessageDialog(null,"Error, Cannot Update");
                    }

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

    @FXML
    void click(MouseEvent event) {
        ArrayList<DeliverDTO> itm = new ArrayList<>(tbl_with.getSelectionModel().getSelectedItems());
        for(
                DeliverDTO delDTO:itm)

        {
            txt_cid.setText(delDTO.getIDno());
            txt_name.setText(delDTO.getName());
            txt_phone.setText(delDTO.getMobile());
            txt_pwd.setText(delDTO.getPwd());
            cmb_type.setValue(delDTO.getType());
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "admin",
                        "deliver",
                        "viewer",
                        "data entry"
                );

        cmb_type.setItems(options);
    }
    @FXML
    void search(MouseEvent event) throws Exception {
        String did = txt_cid.getText();
        DeliverDTO deliverDTO=ManageDelBussines.findDeliver(did);
        txt_cid.setText(deliverDTO.getIDno());
        txt_name.setText(deliverDTO.getName());
        txt_phone.setText(deliverDTO.getMobile());
        txt_pwd.setText(deliverDTO.getPwd());
        cmb_type.setValue(deliverDTO.getType());
    }

    @FXML
    void searchc(ActionEvent event) throws Exception {
        String did = txt_cid.getText();
        DeliverDTO deliverDTO=ManageDelBussines.findDeliver(did);
        txt_cid.setText(deliverDTO.getIDno());
        txt_name.setText(deliverDTO.getName());
        txt_phone.setText(deliverDTO.getMobile());
        txt_pwd.setText(deliverDTO.getPwd());
        cmb_type.setValue(deliverDTO.getType());
    }
    public void viewTable() {
        tbl_with.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_with.getColumns().get(3).setStyle("-fx-alignment: center");

        tbl_with.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("IDno")
                );
        tbl_with.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("name")
                );
        tbl_with.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("mobile")
                );
        tbl_with.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("type")
                );

        try {
            List<DeliverDTO> delDTOS =
                    ManageDelBussines.getDelivers();
            tbl_with.setItems(FXCollections.observableList(delDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void reset()
    {
        txt_cid.setText("");
        txt_name.setText("");
        txt_pwd.setText("");
        txt_phone.setText("");
        cmb_type.setValue(null);
    }
}
