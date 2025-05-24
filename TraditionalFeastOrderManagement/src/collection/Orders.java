
package collection;
import model.Order;
import java.util.HashSet;
import utils.Inputter;
import utils.Workable;

/**
 *
 * @author xuhoa
 */
public class Orders extends HashSet<Order> implements Workable<Order> {
    
    private Customers customers;
    
    
    public Orders(Customers customers) {
        this.customers = customers;
    }

 
        
    @Override
    public void addNew() {
      
      String customerCode = Inputter.getString("Enter your customer code:");
      // Kiểm tra xem khách hàng có tồn tại không
        if (customers.searchById(customerCode) == null) {
            System.out.println("Customer does not exist. Please register before placing an order.");
            return;
        }
      String menuId = Inputter.inputSetMenuCode();
      int numberOfTables =  Inputter.inputNumOfTables();
      String date = Inputter.inputEventDate();
      this.add(new Order(customerCode, menuId, numberOfTables, date));
     
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public void showAll() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Code    | Customer Name         | Phone         | Email                              ");
        
        System.out.println("--------------------------------------------------------------------------------------");
        }
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
