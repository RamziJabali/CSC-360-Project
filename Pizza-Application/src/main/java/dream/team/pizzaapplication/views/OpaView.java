package dream.team.pizzaapplication.views;


import dream.team.pizzaapplication.classdir.Opa;
import dream.team.pizzaapplication.classdir.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;

public class OpaView extends AnchorPane {

    //Declaring OPA Class to connect it to the view
    // Declaring sizing variables
    private static final double anchorWidth = 900;
    private static final double anchorHeight = 600;
    private static final double buttonWidth = 200;
    private static final double buttonHeight = 30;
    private static final double HBoxWidth = 900;
    private static final double HBoxHeight = 500;
    String currentOrder;
    Order selectedOrder;

    public AnchorPane getOpaView() throws IOException {
        Opa opa = new Opa();
        ArrayList<Order> orders = opa.getOrders();
        // Setting size of the Anchor Pane
        this.setPrefHeight(anchorHeight);
        this.setPrefWidth(anchorWidth);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Adding the listview to save orders
        ListView lv = new ListView();
        lv.setPrefHeight(HBoxHeight);
        lv.setPrefWidth(HBoxWidth);
        lv.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(lv);

        // Creating buttons
        // Declaring GUI control variables and objects
        Button accept = new Button("Accept");
        accept.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        accept.setTextFill(Color.WHITE);
        accept.setPrefHeight(buttonHeight);
        accept.setPrefWidth(buttonWidth);
        accept.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    opa.decideOrder(selectedOrder.getUid(), selectedOrder.getOid(), true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Button reject = new Button("Reject");
        reject.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        reject.setTextFill(Color.WHITE);
        reject.setPrefHeight(buttonHeight);
        reject.setPrefWidth(buttonWidth);
        reject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    opa.decideOrder(selectedOrder.getUid(), selectedOrder.getOid(), false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Adding the grid pane for the buttons
        // list of orders
        GridPane gp = new GridPane();
        gp.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        gp.setPrefWidth(900);
        gp.setPrefHeight(100);
        gp.setTranslateY(500);
        gp.setHgap(200);
        gp.setVgap(50);
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(50));
        gp.add(accept, 0, 0);
        gp.add(reject, 1, 0);
        this.getChildren().add(gp);

        lv.getItems().addAll(orders);
        lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() { //creating on click listener to list view
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                currentOrder = lv.getSelectionModel().getSelectedItem().toString();
                selectedOrder = observableValue.getValue();
            }
        });
        return this;
    }
}
