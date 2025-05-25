
package collection;
import model.Order;
import java.util.HashSet;
import utils.Inputter;
import utils.Workable;
import model.SetMenu;
/**
 *
 * @author xuhoa
 */
public class Orders extends HashSet<Order> implements Workable<Order> {
    
    private Customers customers;
     private SetMenus setMenus;
    
    public Orders(Customers customers, SetMenus setMenus) {
        this.customers = customers;
        this.setMenus = setMenus;
    }
    
 
        
    @Override
    public void addNew() {
      
    
    while(true) {
      String customerCode = Inputter.getString("Enter your customer code:");
        if (customers.searchById(customerCode) == null) {
        System.out.println("Customer does not exist. Please register before placing an order.");
            return;
        }
      String menuId = Inputter.inputSetMenuCode();
      int numberOfTables =  Inputter.inputNumOfTables();
      String date = Inputter.inputEventDate();
      
      Order newOrder = new Order(customerCode, menuId, numberOfTables, date);
      if(this.add(newOrder)) {
        System.out.println("Order placed succesfully!!!");
          
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Customer order information [Order Code : "+ newOrder.getOrderCode() + "]");
        System.out.println("------------------------------------------------------------------------");
        setMenus.showAllMenu();
      } else {
        System.out.println("Dupplicate data!!!!");
      
       
      }
    }
     
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public void showAll() {
        setMenus.showAllMenu();
        System.out.println("------------------------------------------------------------------");
        System.out.println("");
        }

    @Override
    public void readFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveFromeFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }


    

