/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;
import model.Customer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import utils.Acceptable;
import utils.Workable;
import utils.Inputter;
/**
 *
 * @author xuhoa
 */
public class Customers extends ArrayList<Customer> implements Workable<Customer> {

    @Override
    public void addNew() {
        Scanner sc = new Scanner(System.in);
        String answer ="";
        do {
            String id =Inputter.gennerateCustomerCode();
            String name =Inputter.inputName();
            String phoneNumber = Inputter.inputPhoneNumber();
            String email = Inputter.inputEmail();
            this.add(new Customer(id, reorderLastName(name), phoneNumber, email));

            System.out.println("Your info is registered successfully!!");
            System.out.println("Do you want to add another customer?  (Y/N)");
            answer = sc.nextLine();
            if(answer.equalsIgnoreCase("n")) {
                break;
            } else if (answer.equalsIgnoreCase("y")) {
            
            } else {
                System.out.println("Your choice is incorrect!!,try again pls\n");
                
            }
        } while(true);
    }

    @Override
    public void update() {
        Customer result = null;
        Scanner sc = new Scanner(System.in);
        while(true) {
              System.out.println("Enter id to be updated");
              String idToUpdate = sc.nextLine().trim();
              result = searchById(idToUpdate);
         if (result !=null) {
              System.out.println("Enter new info to update or pres 'Enter' to skip");
                break;
           
        } else {
              System.out.println("This customer does not exist!Try again\n");
                }
       }
        //update Name
        while (true) {
            System.out.println("Enter new name to be updated");
            String newName =sc.nextLine();
            if (newName.equals("")) {
                break;
            }
            else if(Acceptable.isValid(newName, Acceptable.NAME_VALID)) {
                result.setName(newName);
                break;
            } else {
                System.out.println("This new name is invalid!!Try again pls\n");
            }
        }
        
        //update phoneNum
        while (true) {
            System.out.println("Enter new phone number to be updated");
            String newPhoneNumber =sc.nextLine();
            if(newPhoneNumber.equals("")) {
                break;
            }
            else if(Acceptable.isValid(newPhoneNumber, Acceptable.PHONE_VALID)) {
                result.setPhoneNumber(newPhoneNumber);
                break;
                
            } else {
                System.out.println("This new phone number is invalid form!!Try again pls\n");
            }
            
        }
        //update email
         while (true) {
            System.out.println("Enter new email to be updated");
            String newEmail =sc.nextLine();
            if(newEmail.equals("")) {
                break;
            }
            else if(Acceptable.isValid(newEmail, Acceptable.EMAIL_VALID)) {
                result.setEmail(newEmail);
                break;
                
            } else {
                System.out.println("This new email is invalid form!!Try again pls\n");
            }
            
        } 
        System.out.println("Update customer information succesfully!!!!!!\n");
    }


    public Customer searchById(String code) {
        Customer toSearch = null;
        for (Customer customer : this) {
            if (customer.getCode().equalsIgnoreCase(code)) {
                toSearch = customer;
                break;
            } 
          
        }
        if(toSearch==null) {
            System.out.println("No customer matches criteria");
        }
        return toSearch;
    }

    @Override
    public void showAll() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|Code    | Customer Name         | Phone         | Email                              ");
        for (Customer x: this) {
            System.out.println(x);
            
        System.out.println("--------------------------------------------------------------------------------------");
        }
    }
    
    
    public List<Customer> fliterByName(String name) {
      List<Customer> nameToFind = new ArrayList<>();
    if (name != null && !name.trim().isEmpty()) {
        String lowerCaseName = name.trim().toLowerCase();
        for (Customer customer : this) {
            if (customer.getName().toLowerCase().contains(lowerCaseName)) {
                nameToFind.add(customer);
            }
        }
        // Sử dụng phương thức sort() của List với Comparator để sắp xếp theo tên
        nameToFind.sort(Comparator.comparing(customer ->
                customer.getName().toLowerCase()));
    }
    return nameToFind;
        
    }
    
     public void printFoundCustomersByNameList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name to search for:");
        String keyword = sc.nextLine().trim();
        List<Customer> searchResults = fliterByName(keyword);
            if (!searchResults.isEmpty()) {
                System.out.println("Matching Customers:"+keyword+"\n");
                System.out.println("------------------------------------------------------------------------");
                System.out.printf("%-8s | %-25s | %-15s | %-30s%n", "Code", "Customer Name", "Phone", "Email");
                System.out.println("------------------------------------------------------------------------");
                
                
                for (Customer customer : searchResults) {
                    System.out.printf("%-8s | %-25s | %-15s | %-30s%n",
                            customer.getCode(), customer.getName(), customer.getPhoneNumber(), customer.getEmail());
                }
                System.out.println("-------------------------------------------------------------------------");
            } else {
                
                System.out.println("Nobody matches the search criteria!");
            }
            
            
    }
    
    
    
   
    public static String reorderLastName(String name) {
        name = name.trim().replaceAll("\\s+", " "); // xoa khoang trang thua
        int lastName = name.lastIndexOf(" "); //// tìm khoang space cuoi cung
        
         // Nếu không tìm thấy dấu cách (tên chỉ có 1 từ)
        if (lastName == -1) {
        return name; // Trả về chính tên đó
        }
        
        String tempName= name.substring(lastName +1); // lay phan ten sau khoang space cuoi
        String leftovers = name.substring(0, lastName);//lay het tat ca truoc khoang space cuoi
        return tempName + " , " +leftovers; // tra ve format (Ten , Ho Ten Dem)
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
