package lk.nnj.mdss.fx.style.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class AboutFormController{

    @FXML
    private AnchorPane root;

    @FXML
    private Label lbl_ic;

    @FXML
    private ImageView lbl_fb;

    @FXML
    private ImageView lbl_twit;

    @FXML
    void clickf(MouseEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("https://www.facebook.com/NNJCreations/").toURI());
    }

    @FXML
    void clickic(MouseEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("https://icons8.com").toURI());
    }

    @FXML
    void clickt(MouseEvent event) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URL("https://twitter.com/NNJ_CREATIONS").toURI());
    }

}
