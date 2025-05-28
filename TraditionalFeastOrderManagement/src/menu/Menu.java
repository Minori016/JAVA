/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import collection.Customers;
import collection.Orders;
import collection.SetMenus;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author xuhoa
 */
public class Menu {
    
    
    public static void functionalities () {
            System.out.println("\n========================FEATURES MENU============================");
            System.out.println("|---------------1.Register customers------------------------------|");
            System.out.println("|---------------2.Update customer information---------------------|");
            System.out.println("|---------------3.Search for customer information by name---------|");
            System.out.println("|---------------4.Display feast menus-----------------------------|");
            System.out.println("|---------------5.Place a feast order-----------------------------|");
            System.out.println("|---------------6.Update order information------------------------|");
            System.out.println("|---------------7.Save data to file-------------------------------|");
            System.out.println("|---------------8.Display Customer or Order lists-----------------|");
            System.out.println("===================================================================");
            
            
    }

    
     public static void displaySavedList(Customers customerList, Orders orderList, SetMenus menuList) {
        Scanner sc = new Scanner(System.in);
       
       
            if (customerList.isEmpty() && orderList.isEmpty()) {
            System.out.println("\n-----------------------------------------");
            System.out.println("| Does not have any customer information   |");
            System.out.println("-------------------------------------------");
            System.out.println("Press Enter to return to main menu...");
            sc.nextLine(); 
            return; 
        }
        while(true) {
            try {
                System.out.println("==============SAVED DATA===================");
                System.out.println("1. Display Registered Customers List       ");
                System.out.println("2. Display Succesfully Placed Orders List  ");
                int choice = sc.nextInt();
                sc.nextLine();
                
                if(choice ==1) {
                    System.out.println("Registerd Customers List :");
                    customerList.showAll();
                    break;
                }
                else if(choice ==2) {
                    System.out.println("Placed Orders List     :");
                    orderList.showAll();
                     break;
                }
                else {
                    System.out.println("Return to main menu...");
                    sc.nextLine();
                    return;
                }
                }
             catch (InputMismatchException e) {
                
                sc.nextLine();
            }
        }
    }
}
