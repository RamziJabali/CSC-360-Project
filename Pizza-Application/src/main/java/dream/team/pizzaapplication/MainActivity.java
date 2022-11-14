package dream.team.pizzaapplication;

import dream.team.pizzaapplication.values.DimensionPresets;
import dream.team.pizzaapplication.views.ChefView;
import dream.team.pizzaapplication.views.LoginView;
import dream.team.pizzaapplication.views.OpaView;
import dream.team.pizzaapplication.views.StudentView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainActivity extends Application {
    private final LoginView loginView = new LoginView();
    private final ChefView chefView = new ChefView();
    private final OpaView opaView = new OpaView();
    private final StudentView studentView = new StudentView();
    private static final int ID_LENGTH = 10;

    @Override
    public void start(Stage stage) throws IOException {
        VBox loginVBox = new VBox();
        loginVBox.setSpacing(DimensionPresets.Spacing.Surrounding.l);
        Label enterIdLabel = new Label("Enter ID");
        Label welcomeBackLabel = new Label("Welcome Back");

        TextArea idTextArea = new TextArea();
        idTextArea.setPrefHeight(DimensionPresets.TextFieldSize.m);
        idTextArea.setPrefWidth(DimensionPresets.TextFieldSize.xxl);
        idTextArea.setPrefColumnCount(ID_LENGTH);

        Button enterButton = new Button("->");
        enterButton.setMaxWidth(DimensionPresets.ButtonSize.m);
        enterButton.setMaxHeight(DimensionPresets.ButtonSize.s);
        HBox loginHBox = new HBox();
        loginHBox.setSpacing(DimensionPresets.Spacing.Surrounding.m);
        loginHBox.setMaxWidth(DimensionPresets.HBox.xl4);
        loginHBox.getChildren().addAll(idTextArea, enterButton);
        loginVBox.getChildren().addAll(welcomeBackLabel, enterIdLabel, loginHBox);
        loginVBox.setAlignment(Pos.CENTER);
        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (idTextArea.getText().trim().equals("chef")) {
                    try {
                        stage.setScene(new Scene(chefView.getChefView(), 900, 600));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (idTextArea.getText().trim().equals("opa")) {
                    try {
                        stage.setScene(new Scene(opaView.getOpaView(), 900, 600));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        stage.setScene(new Scene(studentView.getStudentView(idTextArea.getText().trim()), 900, 600));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        stage.setScene(new Scene(loginVBox, 900, 600));
        stage.setTitle("Login");
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch();
    }
}