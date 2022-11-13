package dream.team.pizzaapplication.classdir;

import java.io.IOException;

import dream.team.pizzaapplication.classdir.Order.Statuses;
import java.lang.Thread;

public class Chef extends User{
    public Chef() throws IOException{
        this.uid = "chef";
        this.settxt();
        checkFileExists();
        readOrders();
    }
    
    public void cookOrder(String userid, int orderid) throws IOException, InterruptedException{
       updateTxtOrderStatus(userid, orderid, Statuses.COOKING); 
       System.out.println("The order is cooking. Starting timer...");
       Thread.sleep(3000); // kill thread for 3 seconds
    }

    public void finishOrder(String userid, int orderid) throws IOException{
       updateTxtOrderStatus(userid, orderid, Statuses.FINISHED); 
       removeOrder(orderid);
    }
}
