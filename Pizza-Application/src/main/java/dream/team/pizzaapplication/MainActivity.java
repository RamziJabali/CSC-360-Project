package dream.team.pizzaapplication;

import dream.team.pizzaapplication.views.ChefView;
import dream.team.pizzaapplication.views.LoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainActivity extends Application {
    private final LoginView loginView = new LoginView();
    private final ChefView chefView = new ChefView();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(chefView.getChefView(), 600, 400));
        stage.setTitle("Login");
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}