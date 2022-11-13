package dream.team.pizzaapplication.views;


import dream.team.pizzaapplication.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.*;
import java.util.Scanner;

public class OpaView extends AnchorPane {
    // Declaring sizing variables
    private static final double anchorWidth = 900;
    private static final double anchorHeight = 600;
    private static final double buttonWidth = 200;
    private static final double buttonHeight = 30;
    private static final double HBoxWidth = 900;
    private static final double HBoxHeight = 500;

    // Declaring GUI control variables and objects
    private Button accept, reject;
    private ListView lv;
    private Order order1;
    private File file;
    private GridPane gp;
    String currentOrder;

    public OpaView() {
        // Setting size of the Anchor Pane
        this.setPrefHeight(anchorHeight);
        this.setPrefWidth(anchorWidth);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Adding the listview to save orders
        lv = new ListView();
        lv.setPrefHeight(HBoxHeight);
        lv.setPrefWidth(HBoxWidth);
        lv.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().add(lv);

        // Creating buttons
        accept = new Button("Accept");
        accept.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        accept.setTextFill(Color.WHITE);
        accept.setPrefHeight(buttonHeight);
        accept.setPrefWidth(buttonWidth);
        accept.setOnAction(new ButtonHandler());
        reject = new Button( "Reject");
        reject.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        reject.setTextFill(Color.WHITE);
        reject.setPrefHeight(buttonHeight);
        reject.setPrefWidth(buttonWidth);
        reject.setOnAction(new ButtonHandler());

        // Adding the grid pane for the buttons
        gp = new GridPane();
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


        // Try-catch blocks for opening and reading the OPA.txt file
        try {
            // Creating file object
            file = new File("C:\\Users\\99kja\\IntelliJProjects\\CSC-360-Project\\Pizza-Application\\src\\main\\java\\dream\\team\\pizzaapplication\\views\\OPA.txt");
            // If the file is empty, throw
            if (file.equals(null)) throw new FileNotFoundException();

            // Put code for file reading here

            // Temporary Order list creator. Will be replaced by stuff needed to actually read a file.
            Order order1 = new Order();
            order1.pizzaType = "cheese";
            order1.pizzaToppings = "101";
            order1.id = "1122334455";
            order1.status = "READY";
            lv.getItems().add(order1);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error: File not Found.");
        } catch (IOException ioException) {
            System.out.println("Error: No input in file.");
        }

        lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() { //creating on click listener to list view
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                currentOrder = lv.getSelectionModel().getSelectedItem().toString();
            }
        });
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            if(e.getSource().equals(accept)) {}
            else {}
        }
    }
}
