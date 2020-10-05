package lk.nnj.mdss.fx.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static void navigateToHome(Node node, Stage mainStage) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("/lk/nnj/mdss/fx/style/MainForm.fxml"));
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);
        mainStage.centerOnScreen();
        mainStage.setTitle("Onet TMS v2.1");
        mainStage.setResizable(false);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/lk/nnj/mdss/fx/style/MainForm.fxml"));
        primaryStage.setTitle("Onet TMS v2.0");
        primaryStage.setScene(new Scene(root, 457.0, 448.0));
        Image image = new Image("/lk/nnj/mdss/fx/assest/main.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
