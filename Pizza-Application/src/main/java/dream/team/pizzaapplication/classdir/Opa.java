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
    
    /*
    * if approved=True: APPROVE orderid for userid
    * if approved=False: REJECT orderid for userid
    */
    public void decideOrder(String userid, int orderid, boolean approved) throws IOException{
        Order transfer;
        if(approved){
            this.updateTxtOrderStatus(userid, orderid, Statuses.APPROVED);
            String temp = removeOrder(orderid);
            transfer = new Order(temp);
            appendTxtOrder(transfer, "chef");
        }else{
            this.updateTxtOrderStatus(userid, orderid, Statuses.REJECTED);
            removeOrder(orderid);
        }
    }
}
