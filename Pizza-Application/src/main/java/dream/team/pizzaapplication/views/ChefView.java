package dream.team.pizzaapplication.views;

import dream.team.pizzaapplication.values.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChefView {
    ArrayList<Order> orderList = new ArrayList<>();

    public HBox getChefView() throws Exception {
        Label studentIdString = new Label();
        Label studentIdNumber = new Label();
        Label pizzaType = new Label();
        Label pizzaOrderType = new Label();
        Label pizzaToppings = new Label();
        Label pizzaOrderToppings = new Label();
        Label pizzaStatusString = new Label();
        Label pizzaOrderStatus = new Label();
        Button cookButton =  new Button("Cook Pizza");
        cookButton.setVisible(false);
        HBox stage = new HBox();
        VBox orderDetails = new VBox();
        orderDetails.getChildren().addAll(studentIdString, studentIdNumber, pizzaType, pizzaOrderType,
                pizzaToppings, pizzaOrderToppings, pizzaStatusString, pizzaOrderStatus, cookButton);
        ListView pizzaListView = new ListView();
        pizzaListView.setMinWidth(450);
        dataBaseToArrayList();
        pizzaListView.getItems().addAll(orderList);
        stage.getChildren().add(pizzaListView);
        stage.getChildren().add(orderDetails);
        pizzaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() {
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                cookButton.setVisible(true);
                studentIdString.setText("Student Id");
                pizzaType.setText("Pizza Type:");
                pizzaToppings.setText("Pizza Toppings:");
                pizzaStatusString.setText("Pizza Status");
                studentIdNumber.setText(observableValue.getValue().id);
                pizzaOrderType.setText(observableValue.getValue().pizzaType);
                pizzaOrderToppings.setText(observableValue.getValue().pizzaToppings);
                pizzaOrderStatus.setText(observableValue.getValue().status);
            }
        });
        cookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            System.out.print("Do something here");
            }
        });
        return stage;
    }

    private void dataBaseToArrayList() throws Exception {
        String FILE_PATH = "/Users/ramzijabali/Documents/Code/CSC-360-Project/Pizza-Application/test";
        File dataBase = new File(FILE_PATH);
        Scanner readDataBase;
        try {
            readDataBase = new Scanner(dataBase);
        } catch (FileNotFoundException e) {
            throw new Exception("File not found!");
        }
        String nextWord;
        while (true) {
            Order order = new Order();
            for (int j = 1; j <= 4; j++) {
                nextWord = readDataBase.next();
                if (!nextWord.equals("EOF")) {
                    switch (j) {
                        case 1:
                            order.id = nextWord;
                            break;
                        case 2:
                            order.pizzaType = nextWord;
                            break;
                        case 3:
                            order.pizzaToppings = nextWord;
                            break;
                        case 4:
                            order.status = nextWord;
                            orderList.add(order);
                            break;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
