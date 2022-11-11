package dream.team.pizzaapplication.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;

public class ChefView {
    String currentOrder = "";
    public HBox getChefView(){
        HBox stage = new HBox();
        Label pizzaOrder = new Label();
        String [] pizza = {"cheese","pep","anchovi"};
        ListView pizzaOrderList = new ListView();
        pizzaOrderList.getItems().addAll(pizza);
        stage.getChildren().add(pizzaOrderList);
        stage.getChildren().add(pizzaOrder);
        pizzaOrderList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentOrder = (String) pizzaOrderList.getSelectionModel().getSelectedItem();
                pizzaOrder.setText(currentOrder);
            }
        });
        return stage;
    }

    private HBox createBoxFromPizzaInformation(String line){
        HBox hbox = new HBox();
        Label label = new Label(line);
        hbox.getChildren().add(label);
        return hbox;
    }
}
