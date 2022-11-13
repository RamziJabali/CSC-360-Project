//package dream.team.pizzaapplication.views;
package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class StudentView extends Application{
	//Variables and Elements
	Stage primaryStage = new Stage();
	int width = 900, height = 600;
	String idNumber;
	double pizzaPrice = 0, toppingPrice = 0;
	TextField ASUID = new TextField();
	RadioButton[] RBtn = new RadioButton[3];
	CheckBox[] CBox = new CheckBox[3];
	Insets INSETS = new Insets(10, 10, 10, 10);
	Insets CINSETS = new Insets(10, 25, 25, 25);
	BorderPane root = new BorderPane();
	Label top = createLabel("Create Your Pizza");
	VBox left = createNavigate();
	HBox center = createMenu();	
	AnchorPane right = createPriceDisplayArea();
		Label outputPrice = new Label("$");
	HBox bottom = createIDChecker();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			right.getChildren().add(outputPrice);
			//Filling BorderPane's Sections
			root.setTop(top);
			root.setCenter(center);
			root.setRight(right);
			root.setLeft(left);
			root.setBottom(bottom);
			
			Scene pizzaMenu = new Scene(root,width,height);
			primaryStage.setTitle("Student's Page: Menu");
			primaryStage.setScene(pizzaMenu);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Creates a Button
	private Button createButton(String text) {
		Button button = new Button(text);
		
		//button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);
		
		button.setMinWidth(150);
		BorderPane.setMargin(button, INSETS);
		BorderPane.setAlignment(button, Pos.CENTER);
		
		return button;
	}
	
	//Creates a Label
	private Label createLabel(String text) {
		Label label = new Label(text);
		
		label.setMaxWidth(Double.MAX_VALUE);
		label.setMaxHeight(Double.MAX_VALUE);
		label.setMinWidth(150);
		label.setAlignment(Pos.CENTER);
		BorderPane.setMargin(label, INSETS);
		BorderPane.setAlignment(label, Pos.CENTER);
		
		return label;
	}
	
	//Creates the Price Display Area
	private AnchorPane createPriceDisplayArea() {
		AnchorPane AP = new AnchorPane();
		AP.setStyle("-fx-background-color: #FFFFFF;");
		AP.setMaxWidth(Double.MAX_VALUE);
		AP.setMaxHeight(Double.MAX_VALUE);
		AP.setMinWidth(150);
		BorderPane.setMargin(AP, INSETS);
		BorderPane.setAlignment(AP, Pos.CENTER);
		return AP;
	}
	
	//Creates the Section for View Order History and View Current Order's Status
	private VBox createNavigate() {
		VBox Options = new VBox();
		
		Options.setAlignment(Pos.CENTER);
		Options.setSpacing(20);
		Options.setPadding(CINSETS);
		
		Button viewStatus = createButton("View Current Order Status");
		viewStatus.setOnAction(event -> {viewStatusButton();});
		
		viewStatus.setMaxWidth(Double.MAX_VALUE);
		viewStatus.setMaxHeight(20);
		viewStatus.setStyle("-fx-border-color: #000000;");
		viewStatus.setPadding(CINSETS);
		
		Button viewHistory = createButton("View Previous Order(s)");
		viewHistory.setOnAction(event -> {viewHistoryButton();});
		viewHistory.setMaxWidth(Double.MAX_VALUE);
		viewHistory.setMaxHeight(20);
		viewHistory.setStyle("-fx-border-color: #000000;");
		viewHistory.setPadding(CINSETS);
		
		Options.getChildren().addAll(viewStatus, viewHistory);
		
		return Options;
	}
	
	//Creates the Main Pizza Menu
	private HBox createMenu() {
		final ToggleGroup groupPizzaType = new ToggleGroup();
		HBox Menu = new HBox();
		Menu.setAlignment(Pos.CENTER);
		Menu.setSpacing(50);
		
		VBox pizzaType = new VBox();
		pizzaType.setSpacing(30);
		
		pizzaType.setMaxWidth(Double.MAX_VALUE);
		pizzaType.setMaxHeight(20);
		pizzaType.setStyle("-fx-border-color: #000000;");
		pizzaType.setPadding(CINSETS);
		
		VBox pizzaToppings = new VBox();
		pizzaToppings.setSpacing(30);
		
		pizzaToppings.setMaxWidth(Double.MAX_VALUE);
		pizzaToppings.setMaxHeight(20);
		pizzaToppings.setStyle("-fx-border-color: #000000;");
		pizzaToppings.setPadding(CINSETS);
		
		Menu.getChildren().addAll(pizzaType, pizzaToppings);
		
		Label label_type = new Label("Pizza Type");
		label_type.setStyle("-fx-translate-y: -20;" + "-fx-background-color: #f4f4f4;");
        String stypes[] = {"Cheese", "Pepperoni", "Veggie"};
        pizzaType.getChildren().add(label_type);
        for( int i = 0; i < stypes.length; i++) {
            RBtn[i] = new RadioButton(stypes[i]);
            RBtn[i].setToggleGroup(groupPizzaType);
            pizzaType.getChildren().add(RBtn[i]);
        }
        VBox.setMargin(RBtn[0], new Insets(-27,0,0,0));
        Label label_topping = new Label("Toppings");
        label_topping.setStyle("-fx-translate-y: -20;" + "-fx-background-color: #f4f4f4;");
        String stops[] = { "ExtraCheese", "Bacon", "Mushroom" };
        pizzaToppings.getChildren().add(label_topping);
        for (int i = 0; i < stops.length; i++) {
			CBox[i] = new CheckBox(stops[i]);
			pizzaToppings.getChildren().add(CBox[i]);
        }
        VBox.setMargin(CBox[0], new Insets(-27,0,0,0));
        RBtn[0].setOnAction(e->{pizzaPrice = 10.00;outputPriceText();});
        RBtn[1].setOnAction(e->{pizzaPrice = 12.00;outputPriceText();});
        RBtn[2].setOnAction(e->{pizzaPrice = 15.00;outputPriceText();});
        toppingCheckBox();
		return Menu;

	}
	
	//Creates a section for inputting ASUID and Submitting the Order
	private HBox createIDChecker(){
		
		HBox toCheck = new HBox();
		toCheck.setAlignment(Pos.CENTER);
		toCheck.setPadding(INSETS);
		toCheck.setSpacing(20);
		ASUID.setPromptText("Enter ASU ID");
		//idNumber = ASUID.getText();
		//System.out.println("ID Numbah : " + idNumber);
		Button submit = createButton("Submit Order");
		submit.setOnAction(event -> {submitOrderButton();});
		toCheck.getChildren().addAll(ASUID, submit);
		return toCheck;
	}
	
	//Method for Submit Button. |NEEDS UPDATE|
	private void submitOrderButton() {
		idNumber = ASUID.getText();
		int ID = Integer.parseInt(idNumber);
		System.out.println("idNumber is: " + ID);
	}
	
	//Method for View History Button. |NEEDS UPDATE|
	private void viewHistoryButton() {
		System.out.println("Order History");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Student's Page: Order History");
		primaryStage.show();
	}
	
	//Method for View Status Button. |NEEDS UPDATE|
	private void viewStatusButton(/*String orderStatus*/) {
		System.out.println("Order Status");
		/**/String orderStatus = "ACCEPTED";
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Order Status");
		alert.setContentText("Order Status: " + orderStatus);
		alert.showAndWait();
	}
	
	//Method to increment(or decrement) topping's price
	private void toppingCheckBox() {
		CBox[0].selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				if(arg2) {
					toppingPrice += 1.5;
					outputPriceText();
				}
				else{
					toppingPrice -= 1.5;
					outputPriceText();
				}
			}
        });
		CBox[1].selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				if(arg2) {
					toppingPrice += 1.5;
					outputPriceText();
				}
				else{
					toppingPrice -= 1.5;
					outputPriceText();
				}
			}
        });
		CBox[2].selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
				// TODO Auto-generated method stub
				if(arg2) {
					toppingPrice += 1.5;
					outputPriceText();
				}
				else{
					toppingPrice -= 1.5;
					outputPriceText();
				}
			}
        });
	}
	
	//Uses pizzaPrice and toppingPrice to display output
	private void outputPriceText() {
		outputPrice.setText("$" + Double.toString(pizzaPrice+toppingPrice));
	}
	
}


