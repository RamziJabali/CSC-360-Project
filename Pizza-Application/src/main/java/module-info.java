module dream.team.pizzaapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens dream.team.pizzaapplication to javafx.fxml;
    exports dream.team.pizzaapplication;
}