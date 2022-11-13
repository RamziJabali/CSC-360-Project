package dream.team.pizzaapplication.classdir;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;


public class Order{
    // Note that if you add/remove data members to Order you must change Order.toString and Order(String[] data)
    public enum Types {CHEESE, PEP, VEGGI};
    public enum Toppings {XCHEESE, BACON, MUSH};
    public enum Statuses {SUBMITTED, APPROVED, REJECTED, COOKING, FINISHED};

    int oid = -1; // Order ID (unique for every individual order)
    String uid = ""; // User ID
    String datetime = "";
    double cost = 0.00;
    Statuses status;
    Types type; // Pizza type
    Set<Toppings> toppings; // Set which contains added pizza toppings 
    // TODO: add timer object member+methods (wait until chef class to do so).
    final String dtFormat = "yyyy-mm-dd hh:mm:ss";

    // Setter methods
    public void setOid(int newoid){
        this.oid = newoid; // Set order ID
    }
    public void setUid(String newuid){
        this.uid = newuid; // Set user ID (owner of order)
    }
    public void setCost(double newcost){
        this.cost = newcost;
        // remove this method? (don't think this would ever need to be called)
    }
    public void setStatus(Statuses newstatus){
        this.status = newstatus;
    }
    public void setType(Types newtype){
        this.type = newtype;
        updateCost(); // update cost to reflect change in pizza's type
    }
    public void addTopping(Toppings newtopping){
        this.toppings.add(newtopping);
        updateCost(); // update cost to reflect adding a new topping
    }
    public void removeTopping(Toppings oldtopping){
        this.toppings.remove(oldtopping);
        updateCost(); // update cost to reflect removing existing topping
    }

    // Getter methods
    public int getOid(){
        return this.oid; // returns unique identifier for this order
    }
    public String getUid(){
        return this.uid; // return student ID for user who issued the order
    }
    public double getCost(){
        return this.cost;
    }
    public Types getType(){
        return this.type;
    }
    public Set<Toppings> getToppings(){
        return this.toppings;
    }
    
    public Order(){
        this.type = Types.CHEESE;
        this.toppings = new HashSet<Toppings>();

        // Automatically instanciate Order's datetime string w/ current date & time.
        Date date = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat(this.dtFormat);
        this.datetime = df.format(date);

        this.oid = 0;
        updateCost();
    }
    // Instanciate order from string representation
    public Order(String newstr){
        String[] data = newstr.split(",",6);
        this.toppings = new HashSet<Toppings>();
        this.oid = Integer.parseInt(data[0]);
        this.uid = data[1];
        this.status = Statuses.valueOf(data[2]);

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.dtFormat);
        this.datetime = data[3];

        this.type = Types.valueOf(data[4]);
        
        // parsing the set of toppings
        data[5] = data[5].replace("[","").replace("]","");
        for (String newtop : data[5].split(",",0)) {
            this.addTopping(Toppings.valueOf(newtop.trim()));
        }
        updateCost();
    }

    // Instanciate order from string array representation
    public Order(String[] data){
        this.toppings = new HashSet<Toppings>();
        this.oid = Integer.parseInt(data[0]);
        this.uid = data[1];
        this.status = Statuses.valueOf(data[2]);

        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern(this.dtFormat);
        this.datetime = data[3];

        this.type = Types.valueOf(data[4]);
        
        // parsing the set of toppings
        data[5] = data[5].replace("[","").replace("]","");
        for (String newtop : data[5].split(",",0)) {
            this.addTopping(Toppings.valueOf(newtop.trim()));
        }
        updateCost();
    }
    
    // Update the cost based on the current values of this.type and this.toppings.
    private void updateCost(){
        switch(this.type){
            case CHEESE:
                cost = 10.00;
                break;
            case PEP:
                cost = 12.00;
                break;
            case VEGGI:
                cost = 15.00;
                break;
        }
        this.cost += 1.50 * this.toppings.size();
    }
    
    // Return a string representation of this order object (for storing in txt file).
    @Override
    public String toString(){
        // "<uuid>,<student id>,<status>,<type>,[<t1>,...]\n"
        String result, ordid, ordstat, ordtype, ordtops;
        ordid = String.format("%08d",this.oid); // String representation of order's unique ID (8 digit width).
        ordstat = this.status.name();
        ordtype = this.type.name();
        ordtops = this.toppings.toString();
        result = ordid + "," + this.uid + "," + ordstat + "," + this.datetime + "," + ordtype + "," + ordtops + "\n";
        return result;
    }
}

