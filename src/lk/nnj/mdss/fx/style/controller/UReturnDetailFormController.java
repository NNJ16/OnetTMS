package lk.nnj.mdss.fx.style.controller;

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
import lk.nnj.mdss.fx.Bussines.ManageQueryBussines;
import lk.nnj.mdss.fx.dto.ReturnDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UReturnDetailFormController implements Initializable {

    @FXML
    private AnchorPane root;

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
    private TableView<ReturnDTO> tbl_return;

    @FXML
    private ImageView lbl_back;

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/UOrderDetailForm.fxml"));
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
    void searchgl(ActionEvent event) {
        String glno = txt_gll.getText();
        viewTableGl(glno);
    }

    @FXML
    void searchsh(ActionEvent event) {
        String tid = txt_tid.getText();
        viewTableTid(tid);
    }

    @FXML
    void searchgll(MouseEvent event) {
        String glno = txt_gll.getText();
        viewTableGl(glno);
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
    void click(MouseEvent event) {
        ArrayList<ReturnDTO> dto = new ArrayList<>(tbl_return.getSelectionModel().getSelectedItems());
        for(ReturnDTO oDTO:dto){
            txt_gll.setText(oDTO.getGlno());
            txt_tid.setText(oDTO.getTid());
        }
    }
    public void initialize(URL location, ResourceBundle resources) {
        viewTable();
    }

    public void viewTable() {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");

        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
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
                        new PropertyValueFactory<>("note")
                );

        try {
            List<ReturnDTO> retDTOS =
                    ManageQueryBussines.findAllRetuns();
            tbl_return.setItems(FXCollections.observableList(retDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableGl(String glno) {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");

        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
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
                        new PropertyValueFactory<>("note")
                );

        try {
            List<ReturnDTO> retDTOS =
                    ManageQueryBussines.findAllRetGlno(glno);
            tbl_return.setItems(FXCollections.observableList(retDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void viewTableTid(String tid) {
        tbl_return.getColumns().get(0).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(1).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(2).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(3).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(4).setStyle("-fx-alignment: center");
        tbl_return.getColumns().get(5).setStyle("-fx-alignment: center");

        tbl_return.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date")
                );
        tbl_return.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("glno")
                );
        tbl_return.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("tid")
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
                        new PropertyValueFactory<>("note")
                );

        try {
            List<ReturnDTO> retDTOS =
                    ManageQueryBussines.findAllRetTid(tid);
            tbl_return.setItems(FXCollections.observableList(retDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


