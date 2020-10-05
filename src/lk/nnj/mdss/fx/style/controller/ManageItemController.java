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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageItemBussines;
import lk.nnj.mdss.fx.dto.ItemDTO;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManageItemController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_back;

    @FXML
    private JFXTextField txt_tid;

    @FXML
    private JFXTextField txt_name;

    @FXML
    private JFXTextField txt_desc;

    @FXML
    private JFXButton btn_add;

    @FXML
    private JFXButton btn_cancle;

    @FXML
    private JFXButton btn_up;

    @FXML
    private TableView<ItemDTO> tbl_item;

    @FXML
    private Label lbl_amount;

    @FXML
    private Label lbl_fee;

    @FXML
    private Label lbl_dep;

    @FXML
    private ImageView lbl_search;

    @FXML
    private ImageView lbl_back1;

    @FXML
    private ImageView lbl_back11;

    @FXML
    private ImageView lbl_back12;

    @FXML
    void Add(ActionEvent event) {
        String tid = txt_tid.getText();
        String name = txt_name.getText();
        String des = txt_desc.getText();

        ItemDTO itemDTO =
                new ItemDTO(
                        tid,
                        name,
                        des
                );
        try {
            if(tid.equals("") || name.equals("") )
            {
                JOptionPane.showMessageDialog(null, "Required One or More Field is Empty");
            }else {
                if(ManageItemBussines.addItem(itemDTO)){
                    JOptionPane.showMessageDialog(null, "Item added Successfully");
                    viewTable();
                    reset();
                }else
                    {
                        JOptionPane.showMessageDialog(null, "Item id already exist");
                    }

            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @FXML
    void Close(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
                String tid = txt_tid.getText();
                try {
                    if(ManageItemBussines.deleteItem(tid))
                    {
                        JOptionPane.showMessageDialog(null, "Deleted Successfully");
                        viewTable();
                        reset();
                    }else
                        {
                            JOptionPane.showMessageDialog(null, "Error! Cannot delete");
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
        ArrayList<ItemDTO> itm = new ArrayList<>(tbl_item.getSelectionModel().getSelectedItems());
        for(
                ItemDTO itemDTO:itm)

        {
            txt_tid.setText(itemDTO.getItemId());
            txt_name.setText(itemDTO.getName());
            txt_desc.setText(itemDTO.getDesc());
        }

    }

    @FXML
    void search(MouseEvent event) throws Exception {
        String tid = txt_tid.getText();
        ItemDTO itemDTO = ManageItemBussines.findItem(tid);
        txt_name.setText(itemDTO.getName());
        txt_desc.setText(itemDTO.getDesc());
    }

    @FXML
    void searchc(ActionEvent event) throws Exception {
        String tid = txt_tid.getText();
        ItemDTO itemDTO = ManageItemBussines.findItem(tid);
        txt_name.setText(itemDTO.getName());
        txt_desc.setText(itemDTO.getDesc());
    }

    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
    }



    @FXML
    void update(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
                String tid = txt_tid.getText();
                String name = txt_name.getText();
                 String des = txt_desc.getText();

                ItemDTO itemDTO=
                    new ItemDTO(
                        tid,
                        name,
                        des
                    );
        try {
            if(tid.equals("") || name.equals("") )
            {
                JOptionPane.showMessageDialog(null, "Required One or More Field is Empty");
            }else {
                if(ManageItemBussines.updateItem(itemDTO))
                {
                    JOptionPane.showMessageDialog(null, "Item updated Successfully");
                    viewTable();
                    reset();
                }else
                {
                    JOptionPane.showMessageDialog(null,"Error! Cannot Update");
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
    public void viewTable() {
        tbl_item.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_item.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_item.getColumns().get(2).setStyle("-fx-alignment: center");


        tbl_item.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("itemId")
                );
        tbl_item.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("name")
                );
        tbl_item.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );

        try {
            List<ItemDTO> itemDTOS =
                    ManageItemBussines.getItems();
            tbl_item.setItems(FXCollections.observableList(itemDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset()
    {
        txt_tid.setText("");
        txt_desc.setText("");
        txt_name.setText("");
    }

}
