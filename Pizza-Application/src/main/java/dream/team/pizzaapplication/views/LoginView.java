package dream.team.pizzaapplication.views;

import dream.team.pizzaapplication.values.DimensionPresets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView {
    private static final int ID_LENGTH = 10;
    private String id = "";

    public VBox getLoginView() {
        VBox loginVBox = new VBox();
        loginVBox.setSpacing(DimensionPresets.Spacing.Surrounding.l);
        Label enterIdLabel = new Label("Enter ID"); //TODO: Add to strings class
        Label welcomeBackLabel = new Label("Welcome Back"); //TODO: Add to strings class

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
        return loginVBox;
    }

    public String getId() {
        return id;
    }
}
