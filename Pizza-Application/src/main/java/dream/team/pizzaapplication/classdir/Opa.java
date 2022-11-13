package dream.team.pizzaapplication.classdir;

import java.io.IOException;

import dream.team.pizzaapplication.classdir.Order.Statuses;

public class Opa extends User{
    public Opa() throws IOException{
        this.uid = "opa";
        this.settxt();
        checkFileExists();
        readOrders();
    } 
    
    public void decideOrder(String userid, int orderid, boolean approved) throws IOException{
        Order transfer;
        if(approved){
            this.updateTxtOrderStatus(userid, orderid, Statuses.APPROVED);
        }else{
            this.updateTxtOrderStatus(userid, orderid, Statuses.REJECTED);
        }
        transfer = new Order(removeOrder(orderid));
        appendTxtOrder(transfer, "chef");
    }
}
