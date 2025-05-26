
package collection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.Order;
import java.util.HashSet;
import java.util.Scanner;
import utils.Inputter;
import utils.Workable;
import model.SetMenu;
import model.Customer;
import utils.Acceptable;
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
        Scanner sc = new Scanner(System.in); // Dung Y/N o cuoi vong lap

        while (true) { // Vòng lặp chính cho phép người dùng chủ động thoát
            double totalCost = 0;
            Customer customer; 
            String customerCode = Inputter.getString("Enter your customer code:");
            customer = customers.SearchById(customerCode); 
            if (customer == null) {
                System.out.println("Customer does not exist. Please register before placing an order.");
                // Neu khong tim dc ma khach hang , thoat chuc nang addNew
                return; 
            }
           ///Lay ma menuId 
            String menuId;
            SetMenu menu;
            while (true) { //lay menuId hop le
                menuId = Inputter.inputSetMenuCode();
                menu = setMenus.findMenuById(menuId);
                if (menu != null) {
                    break; 
                } else {
                    System.out.println("Set Menu ID does not exist. Please try again.");
                }
            }
            //Lay yeu cau con lai va khoi tao don dat tiec
            int numberOfTables = Inputter.inputNumOfTables();
            String date = Inputter.inputEventDate();
            Order newOrder = new Order(customerCode, menuId, numberOfTables, date);
            totalCost = menu.getPrice() * numberOfTables;

            if (this.add(newOrder)) {
                System.out.println("Order placed successfully!!!\n");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer order information [Order Code : " + newOrder.getOrderCode() + "]");
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer code   : " + customer.getCode());
                System.out.println("Customer name   : " + customer.getName()); 
                System.out.println("Phone number    : " + customer.getPhoneNumber());
                System.out.println("Email           : " + customer.getEmail());
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Code of Set Menu: " + menu.getMenuId()); 
                System.out.println("Set menu name   : " + menu.getMenuName());
                System.out.println("Event date      : " + newOrder.getEventDate());
                System.out.println("Number of tables: " + newOrder.getNumOfTables());
                System.out.println("Price           : " + SetMenus.formatPrice(menu.getPrice()) + " VNĐ");
                System.out.println("Ingredients     : \n" + SetMenus.splitFoodFormat(menu.getIngredients()));
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Total cost      : " + SetMenus.formatPrice(totalCost) + " VNĐ");
                System.out.println("------------------------------------------------------------------------");
            } else {
                System.out.println("Dupplicate data! This order already exists.");
            }

            // add don hang moi neu can
                String answer;
                while (true) {
                    System.out.print("Do you want to add another order? (Y/N): ");
                    answer = sc.nextLine().trim();
                if (answer.equalsIgnoreCase("n")) {
                    return; 
              } else if (answer.equalsIgnoreCase("y")) {
                    break; 
              } else {
                    System.out.println("Your choice is incorrect!! Please try again.\n");
    }
}
            
        }
    }
     
    

    @Override
    public void update() {
        //find order id truoc
        Order result = null;
        Scanner sc = new Scanner(System.in);
        while(true) {
              System.out.println("Enter id to be updated");
              String OrderIdToUpdate = sc.nextLine().trim();
              result = SearchById(OrderIdToUpdate);
         if (result !=null) {
              System.out.println("Enter new info to update or pres 'Enter' to skip");
                break;
           
        } else {
              System.out.println("This customer does not exist!Try again\n");
                }
       }
         //update setMenu code
        while (true) {
            System.out.println("Enter new set menu code to be updated");
            String newMenuCode =sc.nextLine();
            if(newMenuCode.equals("")) {
                break;
            }
            else if(Acceptable.isValid(newMenuCode, Acceptable.MENUCODE_VALID)) {
                result.setMenuId(newMenuCode);
                break;
                
            } else {
                System.out.println("This new set menu code is invalid form!!Try again pls\n");
            }
            
        }
        // update number of table
        while (true) {
             System.out.println("Enter new number of tables to be updated:");
             String input = sc.nextLine();
        if (input.equals("")) {
             System.out.println("Enter new info to update or press 'Enter' to skip");
             break;
            }
        try {
            int newTables = Integer.parseInt(input);
            if (newTables > 0) {
                result.setNumOfTables(newTables);
                break;
           }else {
                System.out.println("Number must be greater than 0! Try again pls\n");
        }
          } catch (NumberFormatException e) {
                System.out.println("Invalid input! It must be a number, please try again.\n");
            }
        }
        // update date
        while(true) {
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("Enter new date to be updated!!");
            String newDate = sc.nextLine().trim();
             try {
                LocalDate thatDay = LocalDate.parse(newDate, formatter);
                if (thatDay.isAfter(LocalDate.now())) {
                     result.setEventDate(newDate); // << hople => tra ve
                } else{
                    System.out.println("Date must be in the future. Please try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date or format. Please use dd-MM-yyyy.");
            }
        }
       
    }

   

    @Override
    public void showAll() {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    @Override
    public void readFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveFromeFile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

    @Override
    public Order SearchById(String id) {
        Order toSearch = null;
        for (Order order : this) {
            if (order.getOrderCode().equalsIgnoreCase(id)) {
                toSearch = order;
                break;
            } 
          
        }
        if(toSearch==null) {
            System.out.println("This Order does not exist!!!!!");
        }
        return toSearch;
    }

    
    
   
  }

   
    

