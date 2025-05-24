package utils;

import collection.Customers;
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
    
        
    
}
