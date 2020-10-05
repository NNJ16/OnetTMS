package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageQueryBussines;
import lk.nnj.mdss.fx.dao.Custom.QueryDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_back13;

    @FXML
    private JFXButton btn_place;

    @FXML
    private JFXButton btn_order;

    @FXML
    private ImageView lbl_back;

    @FXML
    private JFXButton btn_deliver;

    @FXML
    private JFXButton btn_cus;

    @FXML
    private ImageView lbl_back1;

    @FXML
    private ImageView lbl_back11;

    @FXML
    private ImageView lbl_back111;

    @FXML
    private ImageView lbl_back1111;

    @FXML
    private JFXButton btn_ret;

    @FXML
    private ImageView lbl_refimg;


    @FXML
    private JFXButton btn_track;

    @FXML
    private JFXButton btn_about;

    @FXML
    private ImageView lbl_aboutimg;

    @FXML
    private JFXButton btn_item;

    @FXML
    private ImageView lbl_back12;

    @FXML
    private Label lbl_torder;

    @FXML
    private Label lbl_to;

    @FXML
    private PieChart chart_pie;

    @FXML
    private JFXDatePicker txt_from;

    @FXML
    private JFXDatePicker txt_to;

    @FXML
    private Label lbl_p;

    @FXML
    private Label lbl_po;

    @FXML
    private Label lbl_d;

    @FXML
    private Label lbl_r;

    @FXML
    private Label lbl_do;

    @FXML
    private Label lbl_ro;

    @FXML
    private JFXButton btn_search;

    @FXML
    private ImageView lbl_back11111;

    private static Stage stage =null;
    @FXML
    void about(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/nnj/mdss/fx/style/AboutForm.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        if(root != null) {
            if(stage == null)
            {
                stage = new Stage();
                stage.setTitle("About");
                Image image = new Image("/lk/nnj/mdss/fx/assest/main.png");
                stage.getIcons().add(image);
                stage.setResizable(false);
                stage.setOnCloseRequest(event1 -> {
                    stage =null;}
                    );
                stage.setScene(new Scene(root));
                stage.show();
            }

        }
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/MainForm.fxml"));
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
    void track(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/TrackingManage.fxml"));
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
    void customer(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/CustomerForm.fxml"));
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
    void dpartners(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/ManageDeliverForm.fxml"));
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
    void order(ActionEvent event) throws IOException {
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
        LocalDate today = LocalDate.now();
        LocalDate d1 = today.withDayOfMonth(1);
        LocalDate d2 = today.withDayOfMonth(today.lengthOfMonth());
        txt_from.setValue(today.withDayOfMonth(1));
        txt_to.setValue(today.withDayOfMonth(today.lengthOfMonth()));
        try {

            int cPen = ManageQueryBussines.countOrder("Pending",d1,d2);
            int cDel = ManageQueryBussines.countOrder("Delivered",d1,d2);
            int cRet = ManageQueryBussines.countOrder("Return",d1,d2);
            int tOrd = cDel+cPen+cRet;
            lbl_to.setText(Integer.toString(tOrd));
            lbl_do.setText(Integer.toString(cDel));
            lbl_po.setText(Integer.toString(cPen));
            lbl_ro.setText(Integer.toString(cRet));
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Pending", cPen),
                            new PieChart.Data("Delivered", cDel),
                            new PieChart.Data("Return", cRet)
                            );
            chart_pie.setData(pieChartData);
        } catch (Exception e) {

        }

    }
    @FXML
    void place(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/PlaceOrderForm.fxml"));
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
    void refund(ActionEvent event) throws IOException {
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
    void search(ActionEvent event) {
        LocalDate d1 = txt_from.getValue();
        LocalDate d2 = txt_to.getValue();
        try {

            int cPen = ManageQueryBussines.countOrder("Pending",d1,d2);
            int cDel = ManageQueryBussines.countOrder("Delivered",d1,d2);
            int cRet = ManageQueryBussines.countOrder("Return",d1,d2);
            int tOrd = cDel+cPen+cRet;
            lbl_to.setText(Integer.toString(tOrd));
            lbl_do.setText(Integer.toString(cDel));
            lbl_po.setText(Integer.toString(cPen));
            lbl_ro.setText(Integer.toString(cRet));
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Pending", cPen),
                            new PieChart.Data("Delivered", cDel),
                            new PieChart.Data("Return", cRet)
                    );
            chart_pie.setData(pieChartData);
        } catch (Exception e) {

        }

    }

    @FXML
    void items(ActionEvent event) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/ManageItem.fxml"));
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
}
