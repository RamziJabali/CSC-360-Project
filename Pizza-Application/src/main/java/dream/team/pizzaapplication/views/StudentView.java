package dream.team.pizzaapplication.views;

import dream.team.pizzaapplication.classdir.Order;
import dream.team.pizzaapplication.classdir.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;

public class StudentView {


    double toppingPrice = 0;
    double pizzaPrice = 0;

    ArrayList<Order> orders = new ArrayList<>();
    VBox listViewVBox = new VBox();
    ListView viewAllOrdersLv = new ListView();
    CheckBox extraCheeseCheckBox = new CheckBox("Extra Cheese");
    CheckBox baconCheckBox = new CheckBox("Bacon");
    CheckBox mushroomCheckBox = new CheckBox("Mushroom");
    ToggleGroup pizzaButtonToggleGroup = new ToggleGroup();
    RadioButton cheeseRadioButton = new RadioButton("Cheese");
    RadioButton pepperoniRadioButton = new RadioButton("Pepperoni");
    RadioButton veggieRadioButton = new RadioButton("Veggi");
    Label totalLabel = new Label("Total:");
    Button submitOrderButton = new Button("Submit Order");


    boolean cheesePizza, veggiePizza, pepperoniPizza, xCheese, mushroom, bacon;

    public BorderPane getStudentView(String studentId) throws IOException {
        Student student = new Student(studentId);
        orders = student.getOrders();
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
        Border borderStyle = new Border(borderStroke);
        Color backgroundColor = Color.valueOf("#f4f4f4");
        VBox vBoxPizzaType = new VBox(10);
//        vBoxPizzaType.setPadding(new Insets(0, 100,0,0));
        vBoxPizzaType.setMinWidth(120);
        vBoxPizzaType.setMaxHeight(100);
        vBoxPizzaType.setBorder(borderStyle);
        vBoxPizzaType.setStyle("-fx-padding: -10 5 0 5;");

        cheeseRadioButton.setPadding(new Insets(5));
        pepperoniRadioButton.setPadding(new Insets(5));
        veggieRadioButton.setPadding(new Insets(5));
        cheeseRadioButton.setToggleGroup(pizzaButtonToggleGroup);
        pepperoniRadioButton.setToggleGroup(pizzaButtonToggleGroup);
        veggieRadioButton.setToggleGroup(pizzaButtonToggleGroup);
        pizzaButtonToggleGroup.getSelectedToggle();

        Label pizzaTypeLabel = new Label("Pizza Type");
        pizzaTypeLabel.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
        vBoxPizzaType.getChildren().addAll(pizzaTypeLabel, cheeseRadioButton, pepperoniRadioButton, veggieRadioButton);

        VBox vBoxToppings = new VBox(10);
        vBoxToppings.setMaxWidth(250);
        vBoxToppings.setMaxHeight(100);
        vBoxToppings.setBorder(borderStyle);
        vBoxToppings.setStyle("-fx-padding: -10 5 0 5;");

        extraCheeseCheckBox.setPadding(new Insets(5));
        baconCheckBox.setPadding(new Insets(5));
        mushroomCheckBox.setPadding(new Insets(5));

        Label pizzaToppingsLabel = new Label("Toppings");
        pizzaToppingsLabel.setBackground(new Background(new BackgroundFill(backgroundColor, null, null)));
        vBoxToppings.getChildren().addAll(pizzaToppingsLabel, extraCheeseCheckBox, baconCheckBox, mushroomCheckBox);
        VBox totalVBox = new VBox(10);
        totalVBox.setMinWidth(250);
        totalVBox.setMaxHeight(100);
        totalVBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        totalVBox.getChildren().add(totalLabel);
        HBox pizzaHBox = new HBox(vBoxPizzaType, vBoxToppings, totalVBox);
        pizzaHBox.setSpacing(40);


        submitOrderButton.setMaxWidth(600);
        submitOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(cheesePizza){
                    try {
                        student.submitOrder(Order.Types.CHEESE, xCheese, bacon, mushroom);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (pepperoniPizza){
                    try {
                        student.submitOrder(Order.Types.PEP, xCheese, bacon, mushroom);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    try {
                        student.submitOrder(Order.Types.VEGGI, xCheese, bacon, mushroom);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                viewAllOrdersLv.getItems().clear();
                viewAllOrdersLv.refresh();
                orders = student.getOrders();
                viewAllOrdersLv.getItems().addAll(orders);
                viewAllOrdersLv.refresh();
            }
        });
        Label label = new Label("Dream Team Pizza");
        label.setPadding(new Insets(0, 50, 0, 0));

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 0, 20));
        borderPane.setLeft(label);
        borderPane.setCenter(pizzaHBox);
        borderPane.setBottom(listViewVBox); //TODO Add HBox with listViews
        listViewVBox.getChildren().addAll(submitOrderButton,viewAllOrdersLv);
        viewAllOrdersLv.getItems().addAll(orders);
        radioButtonPizzaPrice();
        toppingCheckBox();
        return borderPane;
    }

    private void toppingCheckBox() {
        extraCheeseCheckBox.selectedProperty().addListener((arg0, arg1, arg2) -> {
            if (arg2) {
                toppingPrice += 1.5;
                totalLabel.setText("Total: $" + totalPizzaPrice());
                xCheese = true;
            } else {
                toppingPrice -= 1.5;
                xCheese = false;
                totalLabel.setText("Total: $" + totalPizzaPrice());
            }
        });
        baconCheckBox.selectedProperty().addListener((arg0, arg1, arg2) -> {
            if (arg2) {
                toppingPrice += 1.5;
                bacon = true;
                totalLabel.setText("Total: $" + totalPizzaPrice());
            } else {
                toppingPrice -= 1.5;
                bacon = false;
                totalLabel.setText("Total: $" + totalPizzaPrice());
            }
        });
        mushroomCheckBox.selectedProperty().addListener((arg0, arg1, arg2) -> {
            if (arg2) {
                toppingPrice += 1.5;
                mushroom = true;
                totalLabel.setText("Total: $" + totalPizzaPrice());
            } else {
                toppingPrice -= 1.5;
                mushroom = false;
                totalLabel.setText("Total: $" + totalPizzaPrice());
            }
        });
    }

    private void radioButtonPizzaPrice() {
        cheeseRadioButton.setOnAction(actionEvent -> {
            pizzaPrice = 10;
            cheesePizza = true;
            pepperoniPizza = false;
            veggiePizza = false;
            totalLabel.setText("Total: $" + totalPizzaPrice());
        });
        pepperoniRadioButton.setOnAction(actionEvent -> {
            pizzaPrice = 12;
            cheesePizza = false;
            pepperoniPizza = true;
            veggiePizza = false;
            totalLabel.setText("Total: $" + totalPizzaPrice());
        });
        veggieRadioButton.setOnAction(actionEvent -> {
            pizzaPrice = 15;
            cheesePizza = false;
            pepperoniPizza = false;
            veggiePizza = true;
            totalLabel.setText("Total: $" + totalPizzaPrice());
        });

    }

    private double totalPizzaPrice() {
        return pizzaPrice + toppingPrice;
    }
}