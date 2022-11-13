package dream.team.pizzaapplication.classdir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import dream.team.pizzaapplication.classdir.Order.Statuses;
import dream.team.pizzaapplication.classdir.Order.Toppings;
import dream.team.pizzaapplication.classdir.Order.Types;

public class Student extends User{
    public Student(String uid) throws IOException{
        this.uid = uid;
        this.settxt();
        File f = new File(this.txtfile);
        //File f = new File(uid + ".txt");
        checkFileExists(); // If <uid>.txt doesn't exist, then create an empty file for it.
        readOrders();
    }
    
    /*
     * Receives raw pizza information.
     * 1. Create new order object from raw pizza choices.
     * 2. Append new order to student's current working array of orders.
     * 3. Append string representation of new order to student's txtfile.
     * 4. Append string representation of new order to opa.txt
     */
    public void submitOrder(Types newtype, boolean xcheese, boolean bacon, boolean mush) throws IOException{
        Order ord = new Order();

        ord.setOid(getNextOid());
        ord.setUid(this.uid);
        ord.setStatus(Statuses.SUBMITTED);
        
        if(xcheese) ord.addTopping(Toppings.XCHEESE);
        if(bacon) ord.addTopping(Toppings.BACON);
        if(mush) ord.addTopping(Toppings.MUSH);

        this.orders.add(ord);
        this.appendTxtOrder(ord, this.uid);
        this.appendTxtOrder(ord, "opa");
    }
    
    // Checks the appropriate value for the next unique order ID (references counter.txt).
    private int getNextOid() throws IOException{
        String counterpath = "txtdir/counter.txt";
        int counter = 0;
        try {
            File myObj = new File(counterpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                counter = Integer.parseInt(myReader.nextLine());
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return counter;
    }
}
