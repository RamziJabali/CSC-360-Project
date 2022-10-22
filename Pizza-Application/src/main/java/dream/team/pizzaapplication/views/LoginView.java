package dream.team.pizzaapplication.views;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView {
    private static final int ID_LENGTH = 10;
    private String id = "";

    public VBox getLoginView() {
        VBox loginVBox = new VBox();
        loginVBox.setSpacing(20); // TODO: Add these values to dimension presets class

        Label enterIdLabel = new Label("Enter ID"); //TODO: Add to strings class
        Label welcomeBackLabel = new Label("Welcome Back"); //TODO: Add to strings class

        TextArea idTextArea = new TextArea();
        idTextArea.setPrefHeight(50); // TODO: Add these values to dimension presets class
        idTextArea.setPrefWidth(200); // TODO: Add these values to dimension presets class
        idTextArea.setPrefColumnCount(ID_LENGTH);// TODO: Add these values to dimension presets class

        Button enterButton = new Button("->");
        enterButton.setMaxWidth(40);// TODO: Add these values to dimension presets class
        enterButton.setMaxHeight(20);// TODO: Add these values to dimension presets class
        HBox loginHBox = new HBox();
        loginHBox.setSpacing(20); // TODO: Add these values to dimension presets class
        loginHBox.getChildren().addAll(idTextArea, enterButton);
        loginVBox.getChildren().addAll(welcomeBackLabel, enterIdLabel, loginHBox);
        return loginVBox;
    }

    public String getId() {
        return id;
    }
}
