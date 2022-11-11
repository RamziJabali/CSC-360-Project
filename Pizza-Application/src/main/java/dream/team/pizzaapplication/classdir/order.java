package dream.team.pizzaapplication.classdir;
import java.util.Set;

enum Types {CHEESE, PEP, VEGGI};
enum Toppings {XCHEESE, BACON, MUSH};
enum Statuses {SUBMITTED, APPROVED, REJECTED, COOKING, FINISHED};

public class order {
    double cost = 0.00;
    Statuses status;
    Types type;
    Set<Toppings> toppings;
    // TODO: add timer object (wait until chef class).

    // Setter methods
    public void setCost(double newcost){
        this.cost = newcost;
        // remove this method?
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
    public double getCost(){
        return this.cost;
    }
    public Types getType(){
        return this.type;
    }
    public Set<Toppings> getToppings(){
        return this.toppings;
    }
    
    public order(){
        this.type = Types.CHEESE;
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
}

