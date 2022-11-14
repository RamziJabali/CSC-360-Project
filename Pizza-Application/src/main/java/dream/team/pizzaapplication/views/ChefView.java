package dream.team.pizzaapplication.views;

import dream.team.pizzaapplication.classdir.Chef;
import dream.team.pizzaapplication.classdir.Order;
import dream.team.pizzaapplication.classdir.Order.Statuses;
import dream.team.pizzaapplication.values.DimensionPresets;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class ChefView {
    ArrayList<Order> orderList;
    Order selectedOrder = null;

    public HBox getChefView() throws Exception {
        Chef chef = new Chef();
        orderList = chef.getOrders();
        Label studentIdString = new Label();
        Label studentIdNumber = new Label();
        Label pizzaType = new Label();
        Label pizzaOrderType = new Label();
        Label pizzaOrderTimeString = new Label();
        Label pizzaOrderDateTime = new Label();
        Label pizzaToppings = new Label();
        Label pizzaOrderToppings = new Label();
        Label pizzaStatusString = new Label();
        Label pizzaOrderStatus = new Label();
        Button cookButton = new Button("Cook Pizza");
        Button finishButton = new Button("Finish Order");
        cookButton.setVisible(false);
        finishButton.setVisible(false);
        HBox stage = new HBox();
        VBox orderDetails = new VBox();
        orderDetails.getChildren().addAll(studentIdString, studentIdNumber, pizzaType, pizzaOrderType,
                pizzaToppings, pizzaOrderToppings, pizzaOrderTimeString, pizzaOrderDateTime, pizzaStatusString,
                pizzaOrderStatus, cookButton, finishButton);

        orderDetails.setSpacing(DimensionPresets.Spacing.Surrounding.m);
        ListView pizzaListView = new ListView();
        pizzaListView.setMinWidth(600);
        pizzaListView.getItems().addAll(orderList);
        stage.getChildren().add(pizzaListView);
        stage.getChildren().add(orderDetails);
        pizzaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() {
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                cookButton.setVisible(true);
                studentIdString.setText("Student Id:");
                pizzaType.setText("Pizza Type:");
                pizzaToppings.setText("Pizza Toppings:");
                pizzaStatusString.setText("Pizza Status:");
                pizzaOrderTimeString.setText("Pizza Order Time:");
                studentIdNumber.setText(observableValue.getValue().getUid());
                pizzaOrderType.setText(observableValue.getValue().getType().toString());
                pizzaOrderToppings.setText(observableValue.getValue().getToppings().toString());
                pizzaOrderStatus.setText(observableValue.getValue().getStatus().toString());
                pizzaOrderDateTime.setText(observableValue.getValue().getDateTime());
                selectedOrder = observableValue.getValue();
                System.out.println(selectedOrder);
            }
        });
        cookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    chef.cookOrder(selectedOrder.getUid(), selectedOrder.getOid());
                    finishButton.setVisible(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("Cooking Pizza");
                // here
                pizzaListView.getItems().clear();
                pizzaListView.refresh();
                int index = orderList.indexOf(selectedOrder);
                orderList.get(index).setStatus(Statuses.COOKING);
                //orderList = chef.getOrders();
                pizzaListView.getItems().addAll(orderList);
                pizzaListView.refresh();
                //finishButton.setVisible(false);
            }
        });

        finishButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    chef.finishOrder(selectedOrder.getUid(), selectedOrder.getOid());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                pizzaListView.getItems().clear();
                pizzaListView.refresh();
                orderList.remove(selectedOrder);
                pizzaListView.getItems().addAll(orderList);
                pizzaListView.refresh();
                finishButton.setVisible(false);
            }
        });
        return stage;
    }
}
