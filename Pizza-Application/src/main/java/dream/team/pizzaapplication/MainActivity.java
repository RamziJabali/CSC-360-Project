package dream.team.pizzaapplication;

import dream.team.pizzaapplication.views.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainActivity extends Application {
    private final LoginView loginView = new LoginView();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loginView.getLoginView(), 600, 400);
        stage.centerOnScreen();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}