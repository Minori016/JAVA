/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import java.util.Scanner;
import menu.Menu;
import collection.Customers;
import collection.Orders;

import java.util.InputMismatchException;
import collection.SetMenus;
/**
 *
 * @author xuhoa
 */
public class Main {

    public static void main(String[] args) {
        int choice = 0;
        Customers customerList = new Customers();
        SetMenus menuList = new SetMenus();
        Orders orderList = new Orders(customerList, menuList);
        Scanner sc = new Scanner(System.in);
        
        do {
            try {

                Menu.functionalities();
                System.out.println("Please choose functions :");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                        customerList.addNew();
                        customerList.showAll();
                        break;
                    case 2:
                        customerList.update();
                        customerList.showAll();
                        break;
                    case 3:
                        customerList.printFoundCustomersByNameList();
                        break;
                    case 4:
                        menuList.readFromFile();
                        menuList.showAllMenu();
                        break;
                    case 5:
                        orderList.addNew();
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! we only have 8 features(1-8)");
                sc.nextLine();
            }

        } while (choice > 0 && choice < 9);

    
}
}
