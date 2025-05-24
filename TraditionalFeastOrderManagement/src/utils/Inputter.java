package utils;

import collection.Customers;
import java.time.LocalDateTime;
import java.util.Scanner;
import model.Customer;


public class Inputter {


   
 
    
    public static String gennerateCustomerCode() {
        String r;
        r="CGK".charAt((int)(Math.random()*3))+String.format("%04d", (int)(Math.random() * 10000));
        if (r.matches(Acceptable.CODE_VALID));  {
        return r;
    }
        
    }
    public static String inputName() {
       String name ="";
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your name");
            name = sc.nextLine();
            if(name.matches(Acceptable.NAME_VALID)) {
            break;
        } else {
                System.out.println("Your name is in invalid format!! Please try again");
                }
            
      
    } 
        return name;
}
    public static String inputPhoneNumber() {
      String phoneNumber ="";
      Scanner sc = new Scanner(System.in);
      while (true) {
          System.out.println("Enter your phone number:");
          phoneNumber = sc.nextLine();
          if (phoneNumber.matches(Acceptable.PHONE_VALID)) {
              break;
          }
          else {
              System.out.println("Your phone number is in invalid format!! Please try again");
          }
          
      }
      return phoneNumber;
    }
    
    
    public static String inputEmail() {
        String email = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your email:");
            email = sc.nextLine();
            if (email.matches(Acceptable.EMAIL_VALID)) {
                break;
            } else {
                 System.out.println("Your email is in invalid format!! Please try again");
        }
        
    }
        return email;
}
    
    public static String inputSetMenuCode() {
        String menuCode ="";
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter set menu code:");
            menuCode = sc.nextLine();
            if(menuCode.matches(Acceptable.MENUCODE_VALID)) {
                break;
            }   else {
                System.out.println("Your set menu code is not in our menu!Please try again");
                
            }
            
        }
        return menuCode;
    }
    
    
    public static String inputEventDate() {
        String date ="";
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter date to sign up event: (dd-MM-yyyy)");
            date = sc.nextLine();
            LocalDateTime ldt = LocalDateTime.parse(date);
            if(ldt.isAfter(LocalDateTime.now())) {
                break;
            }
            else if(ldt.isBefore(LocalDateTime.now())) {
                System.out.println("");
            }
        }
        return date;
    }
    
    public static int inputNumOfTables() {
        int table = 0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter number of tables:");
            table = sc.nextInt();
            if(table>0) {
                break;
            } else {
                System.out.println("This information must be greater than 0 , try again pls");
                
            }
            
           
        }
        return table;
            
    }
    
    public static String getString(String message) {
    Scanner sc = new Scanner(System.in);
    System.out.print(message);
    return sc.nextLine().trim();
}

    
    
    
    
        
    
}
