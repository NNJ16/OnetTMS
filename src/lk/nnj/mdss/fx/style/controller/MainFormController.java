package lk.nnj.mdss.fx.style.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.nnj.mdss.fx.Bussines.ManageDelBussines;
import lk.nnj.mdss.fx.dto.DeliverDTO;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView lbl_back111;

    @FXML
    private JFXTextField txt_user;

    @FXML
    private JFXPasswordField txt_pass;

    @FXML
    private JFXButton btn_sign;

    @FXML
    private ImageView lbl_back11;
    public void validate()
    {
        String uid =txt_user.getText();
        String pwd = txt_pass.getText();
        try
        {
            DeliverDTO deliverDTO = ManageDelBussines.findDeliver(uid);
            if(deliverDTO != null)
            {
                String uid1 = deliverDTO.getIDno();
                String pwd1 = deliverDTO.getPwd();
                String type = deliverDTO.getType();
                if(uid.equals(uid1) && pwd.equals(pwd1) && "admin".equals(type))
                {
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
                }else if(uid.equals(uid1) && pwd.equals(pwd1) && "data entry".equals(type))
                {
                    Parent root = null;
                    root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/UPlaceOrderForm.fxml"));
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

                }else if(uid.equals(uid1) && pwd.equals(pwd1) && "deliver".equals(type))
                {
                    Parent root = null;
                    root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/UTrackingManage.fxml"));
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
                }else if(uid.equals(uid1) && pwd.equals(pwd1) && "viewer".equals(type))
                {
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
                }else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials.");
                }
            }else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials.");
                }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    void log(ActionEvent event) throws Exception {
        validate();
    }
    @FXML
    void logc (ActionEvent event) throws Exception {
       validate();
    }
}