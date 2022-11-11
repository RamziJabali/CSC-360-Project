package dream.team.pizzaapplication.views;

import dream.team.pizzaapplication.values.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChefView {
    String currentOrder = "";
    ArrayList<Order> orderList = new ArrayList<>();
    public HBox getChefView() throws Exception {
        HBox stage = new HBox();
        Label pizzaOrder = new Label();
        ListView pizzaListView = new ListView();
        dataBaseToArrayList();
        pizzaListView.getItems().addAll(orderList);
        stage.getChildren().add(pizzaListView);
        stage.getChildren().add(pizzaOrder);
        pizzaListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Order>() {
            @Override
            public void changed(ObservableValue<? extends Order> observableValue, Order order, Order t1) {
                currentOrder = pizzaListView.getSelectionModel().getSelectedItem().toString();
                pizzaOrder.setText(currentOrder);
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
        while(true){
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
