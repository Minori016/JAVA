
package collection;
import utils.FileUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Order;
import java.util.HashSet;
import java.util.List;
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
public class Orders extends HashSet<Order> implements Workable<Order>  {
    private String filePath ="src/data/feast_order_service.dat";
    boolean saved= false;
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
                System.out.println("|Code    | Customer Name         | Phone         | Email                ");
                System.out.println(customer); 
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
              System.out.println("Enter Order id to be updated");
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
             // Enter to skip
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
         // Enter to skip
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
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false); // kh tu dieu chinh cac ngay nhu (31-02-2026 thanh > 03-03-2026)

            System.out.println("Enter new date to be updated (dd-MM-yyyy) or press 'Enter' to skip:");
            String newDate = sc.nextLine().trim(); // Lấy input từ người dùng

            // Enter to skip
            if (newDate.equals("")) {
                break; 
            }

            try {
                Date thatDay = sdf.parse(newDate); // Parse string
                Date today = new Date(); // Lấy ngày giờ hiện tại

                // Kiểm tra xem ngày có ở tương lai không
                if (thatDay.after(today)) {
                     result.setEventDate(newDate); 
                     
                     break; 
                } else {
                    System.out.println("Date must be in the future. Please try again.");
                }
            } catch (ParseException e) { // Bắt ParseException
                System.out.println("Invalid date or format. Please use dd-MM-yyyy.");
            }
        }
        
        System.out.println("Update order information succesfully!!!!!!\n"); // Thông báo cuối cùng
        Customer customer = customers.SearchById(result.getCustomerCode());
        SetMenu menu = setMenus.findMenuById(result.getMenuId()); // < Lấy menu moi (nếu có doi menu)
        
        // kiem tra xem co lay dc thong tin chua
        if (customer != null && menu != null) {
            // tinh lai tien
            double totalCost = menu.getPrice() * result.getNumOfTables(); 

            // ... (In cac thong tin theo cap nhat) ...
            
            // HIỂN THỊ lai thong tin moi dua tren thong tin cap nhat
                
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer Name   :"+customer.getName());
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Customer Code   : " + result.getCustomerCode()); 
                System.out.println("Code of Set Menu: " + result.getMenuId()); 
                System.out.println("Set menu name   : " + menu.getMenuName());
                System.out.println("Event date      : " + result.getEventDate());
                System.out.println("Number of tables: " + result.getNumOfTables());
                System.out.println("Price           : " + SetMenus.formatPrice(menu.getPrice()) + " VNĐ");
                System.out.println("Ingredients     : \n" + SetMenus.splitFoodFormat(menu.getIngredients()));
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Total cost      : " + SetMenus.formatPrice(totalCost) + " VNĐ");
                System.out.println("------------------------------------------------------------------------");
        } 
       
    }

   

    @Override
    public void showAll() {
        System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | %-12s | %-8s | %-15s | %-10s | %-15s  |%n",
                              "Order ID",      
                              "Customer Code", 
                              "Menu ID",         
                              "Number of tables",  
                              "Date",     
                              "Total Cost(VNÐ)");
        for (Order x: this) {
            SetMenu menu = setMenus.findMenuById(x.getMenuId());
            double totalCost = menu.getPrice()* x.getNumOfTables();
            String convertTotalCost = SetMenus.formatPrice(totalCost);
             System.out.printf("| %-15s | %-12s | %-8s | %-15d | %-10s | %-15s |%n",
                              x.getOrderCode(),      
                              x.getCustomerCode(), 
                              x.getMenuId(),         
                              x.getNumOfTables(),  
                              x.getEventDate(),     
                              convertTotalCost+"  VNÐ ");
        
        System.out.println("--------------------------------------------------------------------------------------");
        }
        
        }

   
    
    
    

    @Override
    public Order SearchById(String OrderCode) {
        Order toSearch = null;
        for (Order order : this) {
            if (order.getOrderCode().equalsIgnoreCase(OrderCode)) {
                toSearch = order;
                break;
            } 
          
        }
        if(toSearch==null) {
            System.out.println("This Order does not exist!!!!!");
        }
        return toSearch;
    }

    public void readFile(){ // doc va nap du lieu tu file vao ds don hang
        List<Order> list = FileUtils.readFromFile(this.filePath);
        for(Order i : list)
        this.saved=true; // flag de luu
    }
    
    // ham chuyen doi tu HashSet<Order> sang List collection
    private List<Order> toList() {
        return new ArrayList<>(this);
    }
    
    
    // luu due lieu xuong file
    public void saveToFile() {
        if(this.saved) 
            return;
        FileUtils.saveToFile(toList(), filePath);
        System.out.println("Orders data has been succfully saved to 'feast_order_service.dat'");
    }
    
    
   
  }

   
    

