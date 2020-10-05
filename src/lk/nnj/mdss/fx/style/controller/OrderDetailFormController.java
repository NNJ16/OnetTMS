package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.nnj.mdss.fx.Bussines.ManageCusBussines;
import lk.nnj.mdss.fx.Bussines.ManageOrderBussines;
import lk.nnj.mdss.fx.Bussines.ManageQueryBussines;
import lk.nnj.mdss.fx.Bussines.ManageTrackBussines;
import lk.nnj.mdss.fx.Entity.OrderDt;
import lk.nnj.mdss.fx.dao.Custom.impl.ConDAOImpl;
import lk.nnj.mdss.fx.dto.*;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OrderDetailFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_back;

    @FXML
    private ImageView lbl_oids;

    @FXML
    private JFXTextField txt_oid;

    @FXML
    private ImageView lbl_glls;

    @FXML
    private JFXTextField txt_gll;

    @FXML
    private ImageView lbl_ships;

    @FXML
    private JFXTextField txt_tid;

    @FXML
    private ImageView lbl_viewall;

    @FXML
    private Label lbl_sprice;

    @FXML
    private Label lbl_cost;

    @FXML
    private Label lbl_ecost;

    @FXML
    private Label lbl_pcost;

    @FXML
    private Label lbl_profit;

    @FXML
    private Label lbl_sprice2;

    @FXML
    private TableView<OrderDtDTO> tbl_order;

    @FXML
    private Label lbl_cid;

    @FXML
    private JFXButton btn_add;

    @FXML
    private ImageView lbl_back111;

    @FXML
    private JFXButton btn_edit;

    @FXML
    private ImageView lbl_back1111;

    @FXML
    private JFXComboBox<String> cmb_status;

    @FXML
    private ImageView lbl_status;

    @FXML
    private JFXButton btn_add1;

    @FXML
    private ImageView lbl_back1112;

    @FXML
    void Click(MouseEvent event) {
        ArrayList<OrderDtDTO> dto = new ArrayList<>(tbl_order.getSelectionModel().getSelectedItems());
        for(OrderDtDTO oDTO:dto){
            txt_gll.setText(oDTO.getGlno());
            txt_tid.setText(oDTO.getTid());
            txt_oid.setText(oDTO.getOid());
        }
    }

    @FXML
    void ViewD(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/TrackinDetailForm.fxml"));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
        }
    }
    @FXML
    void ViewR(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/ReturnDetailForm.fxml"));
        if (root != null) {
            Scene subScene = new Scene(root);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(subScene);
            primaryStage.centerOnScreen();
            primaryStage.setResizable(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
            tt.setFromX(-subScene.getWidth());
            tt.setToX(0);
            tt.play();
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
    void edit(ActionEvent event) {
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Master Password", JOptionPane.OK_CANCEL_OPTION);

        if (okCxl == JOptionPane.OK_OPTION) {
            String password = new String(pf.getPassword());
            if (password.equals("Onet@123")) {
                if(txt_oid.getText().equals("") || txt_tid.getText().equals("") || txt_gll.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Select Order to Edit");
                }else{

                    FXMLLoader loader =new FXMLLoader();
                    loader.setLocation(getClass().getResource("/lk/nnj/mdss/fx/style/EditOrderForm.fxml"));
                    try{
                        loader.load();
                    }catch (Exception e){

                    }
                    EditOrderFormController display=loader.getController();
                    String oid = txt_oid.getText();
                    String glno = txt_gll.getText();
                    String tid = txt_tid.getText();

                    try {
                        OrderDTO oDTO = ManageOrderBussines.findOrder(oid);
                        CustomerDTO cDTO = ManageCusBussines.findCustomer(glno);
                        TrackDTO tDTO = ManageTrackBussines.findTrack(tid);
                        System.out.println("Date"+oDTO.getDate());
                        display.setText(
                                oid,
                                oDTO.getDate(),
                                tDTO.getTid(),
                                tDTO.getStatus(),
                                cDTO.getGlno(),
                                cDTO.getBAname(),
                                cDTO.getPhone(),
                                cDTO.getAddr1(),
                                cDTO.getAddr2(),
                                cDTO.getCity()
                        );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Parent p=loader.getRoot();
                    if (p != null) {
                        Scene subScene = new Scene(p);
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

            }else
            {
                JOptionPane.showMessageDialog(null,"Entered Password is not Correct");
            }
        }

    }

    @FXML
    void searchgll(MouseEvent event) {
        String glno = txt_gll.getText();
        viewTableCid(glno);
    }

    @FXML
    void searchoid(MouseEvent event) {
        String oid = txt_oid.getText();
        viewTableOid(oid);
    }

    @FXML
    void searchship(MouseEvent event) {
        String tid = txt_tid.getText();
        viewTableTid(tid);
    }

    @FXML
    void viewAll(MouseEvent event) {
        viewTable();
    }

    @FXML
    void viewState(MouseEvent event) {
        String sts = cmb_status.getValue().toString();
        viewTableSts(sts);
    }
    @FXML
    void searchglls(ActionEvent event) {
        String glno = txt_gll.getText();
        viewTableCid(glno);
    }

    @FXML
    void searchoids(ActionEvent event) {
        String oid = txt_oid.getText();
        viewTableOid(oid);
        System.out.println("Run");
    }

    @FXML
    void searchships(ActionEvent event) {
        String tid = txt_tid.getText();
        viewTableTid(tid);
    }
    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Pending",
                        "Delivered",
                        "Return"
                );
        cmb_status.setItems(options);
    }

    public void viewTable() {
        tbl_order.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_order.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("oid")
                );
        tbl_order.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_order.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_order.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("odate")
                );
        tbl_order.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_order.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_order.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_order.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );


        try {
            List<OrderDtDTO> orderDtDTOS =
                    ManageQueryBussines.findAllOrderDts();
            tbl_order.setItems(FXCollections.observableList(orderDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void viewTableOid(String oid) {
        tbl_order.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_order.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("oid")
                );
        tbl_order.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_order.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_order.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("odate")
                );
        tbl_order.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_order.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_order.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_order.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );


        try {
            List<OrderDtDTO> orderDtDTOS =
                    ManageQueryBussines.findAllOdtsOid(oid);
            tbl_order.setItems(FXCollections.observableList(orderDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableCid(String cid) {
        tbl_order.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_order.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("oid")
                );
        tbl_order.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_order.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_order.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("odate")
                );
        tbl_order.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_order.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_order.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_order.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );


        try {
            List<OrderDtDTO> orderDtDTOS =
                    ManageQueryBussines.findAllOdtsCid(cid);
            tbl_order.setItems(FXCollections.observableList(orderDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableTid(String tid) {
        tbl_order.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_order.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("oid")
                );
        tbl_order.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_order.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_order.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("odate")
                );
        tbl_order.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_order.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_order.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_order.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );


        try {
            List<OrderDtDTO> orderDtDTOS =
                    ManageQueryBussines.findAllOdtsTid(tid);
            tbl_order.setItems(FXCollections.observableList(orderDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableSts(String sts) {
        tbl_order.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_order.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_order.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("oid")
                );
        tbl_order.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_order.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_order.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("odate")
                );
        tbl_order.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_order.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_order.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_order.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("city")
                );


        try {
            List<OrderDtDTO> orderDtDTOS =
                    ManageQueryBussines.findAllOdtsState(sts);
            tbl_order.setItems(FXCollections.observableList(orderDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
