package lk.nnj.mdss.fx.style.controller;

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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageQueryBussines;
import lk.nnj.mdss.fx.dto.DelDtDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TrackingDetailController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_ships;

    @FXML
    private JFXTextField txt_tid;

    @FXML
    private ImageView lbl_viewall;

    @FXML
    private JFXComboBox<String> cmb_status;

    @FXML
    private ImageView lbl_status;

    @FXML
    private TableView<DelDtDTO> tbl_return;

    @FXML
    private ImageView lbl_back;

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/OrderDetailForm.fxml"));
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
    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Delivered",
                        "Return"
                );
        cmb_status.setItems(options);
    }
    @FXML
    void searchc(ActionEvent event) {
        String tid = txt_tid.getText();
        viewTable(tid);
    }

    @FXML
    void searchship(MouseEvent event) {
        String tid = txt_tid.getText();
        viewTable(tid);
    }

    @FXML
    void viewAll(MouseEvent event) {
        viewTable();
    }

    @FXML
    void viewState(MouseEvent event) {
        String sts = cmb_status.getValue();
        viewTableState(sts);
    }
    public void viewTable() {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(6).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(7).setStyle("-fx-alignment: center");

        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_return.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_return.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_return.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("note")
                );
        tbl_return.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("delby")
                );


        try {
            List<DelDtDTO> delDtDTOS =
                    ManageQueryBussines.findAllTids();
            tbl_return.setItems(FXCollections.observableList(delDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void click(MouseEvent event) {
        ArrayList<DelDtDTO> dto = new ArrayList<>(tbl_return.getSelectionModel().getSelectedItems());
        for(DelDtDTO oDTO:dto){
            txt_tid.setText(oDTO.getTid());
        }
    }

    public void viewTable(String tid) {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(6).setStyle("-fx-alignment: center");


        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_return.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_return.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_return.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("delby")
                );


        try {
            List<DelDtDTO> delDtDTOS =
                    ManageQueryBussines.findAllTids(tid);
            tbl_return.setItems(FXCollections.observableList(delDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableState(String sts) {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(6).setStyle("-fx-alignment: center");


        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("baname")
                );
        tbl_return.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("desc")
                );
        tbl_return.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("status")
                );
        tbl_return.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("delby")
                );


        try {
            List<DelDtDTO> delDtDTOS =
                    ManageQueryBussines.findAllTidsState(sts);
            tbl_return.setItems(FXCollections.observableList(delDtDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
