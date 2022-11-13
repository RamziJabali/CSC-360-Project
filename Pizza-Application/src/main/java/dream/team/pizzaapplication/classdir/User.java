package dream.team.pizzaapplication.classdir;

import dream.team.pizzaapplication.classdir.Order.Statuses;

import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class User{
    String uid;    
    String txtfile; // Path + name to User's txt file.
    ArrayList<Order> orders = new ArrayList<>(); // Array to store the "current working" list of orders.

    public void readOrders() throws IOException{
      readOrders(this.orders, this.uid);
    }
    // Read user's txtfile, parsing it into an array of order objects. 
    public void readOrders(ArrayList<Order> orderList, String userid) throws IOException{
      checkFileExists();
      try {
        File myObj = new File("src/main/java/dream/team/pizzaapplication/txtdir/" + userid + ".txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String[] data = myReader.nextLine().split(",",6);
          orderList.add(new Order(data));
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    // Add string represention of given order to txtfile.
    public void appendTxtOrder(Order neworder, String userid) throws IOException{
      checkFileExists(userid);
      //src/main/java/dream/team/pizzaapplication/txtdir
      try {
        Files.write(Paths.get("src/main/java/dream/team/pizzaapplication/txtdir/" + userid + ".txt"), neworder.toString().getBytes(), StandardOpenOption.APPEND);
      }catch (IOException e) {
        System.out.println("Error in appendTxtOrder");
      }
    }

    // Given an order's unique identifier, remove it from CWS and txtfile.
    public String removeOrder(int orderid) throws IOException{
      String poppedOrd = "?";
      for(Order ord : this.orders){
        if(ord.getOid() == orderid){
          poppedOrd = ord.toString();
          this.orders.remove(ord);
          break;
        }
      }
      this.overwriteTxt(this.uid, this.orders);
      return poppedOrd;
    }
    
    // Overwrite userid.txt with orderList
    public void overwriteTxt(String userid, ArrayList<Order> orderList) throws IOException{
      if(Objects.equals(userid, "counter")){
        System.out.println("Don't do that (tried to used \"counter\" as userid).");
        System.exit(1);
      }
      FileOutputStream outputStream = new FileOutputStream("src/main/java/dream/team/pizzaapplication/txtdir/"+userid+".txt");
      for(Order ord : orderList){
        outputStream.write(ord.toString().getBytes());
      }
      outputStream.close();
    }

    // Change the status of order in <userid>.txt to <newstatus>
    public void updateTxtOrderStatus(String userid, int orderid, Statuses newstatus) throws IOException{
      ArrayList<Order> temp = new ArrayList<>();
      readOrders(temp, userid);
      for(Order ord : temp){
        if(ord.getOid() == orderid){
          ord.setStatus(newstatus);
          break;
        }
      }
      overwriteTxt(userid, temp);
    }
    
    // Check if a txt file for this user exists. If not, create an empty one.
    public void checkFileExists() throws IOException{
      File f = new File(this.txtfile);
      if(!f.exists()){
        f.createNewFile();
      }else{
        System.out.println("File already exists");
      }
    }

    public void checkFileExists(String userid) throws IOException{
      File f = new File("src/main/java/dream/team/pizzaapplication/txtdir/" + userid + ".txt");
      if(!f.exists()){
        f.createNewFile();
      }else{
        System.out.println("File already exists");
      }
    }

    // Set txtfile value
    public void settxt(){
      this.txtfile = "src/main/java/dream/team/pizzaapplication/txtdir/" + uid + ".txt"; // is this right
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }
    
    public void printOrders(){
      for(Order ord : this.orders){
        System.out.println(ord);
      }
    }
    
    //User(String newid){ settxt(); readOrders(); }
}