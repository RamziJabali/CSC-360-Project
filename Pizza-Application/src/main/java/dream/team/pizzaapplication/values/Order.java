package dream.team.pizzaapplication.values;

public final class Order {
    public String id;
    public String pizzaType;
    public String pizzaToppings;
    public String status;

    @Override
    public String toString() {
        return "User ID [" + id + "] - Pizza Type[" + pizzaType + "] - Pizza Toppings [" + pizzaToppings + "] - Order Status [" + status + "]";
    }
}
