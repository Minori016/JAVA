/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Part2;

import java.util.Scanner;

/**
 *
 * @author Legion5
 */



public class Part2 {
    public static void main(String[] args) {
        boolean cont = false;
        do {
            try {
                String StudentID = "";
                String pattern = "SE\\d{6}"; 
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your ID:");
                StudentID = sc.nextLine();
                if (!StudentID.matches(pattern)) {
                    throw new Exception();
                }
                System.out.println("The string is: " + StudentID);
                cont = false; 
            } catch (Exception e) {
                System.out.println("Your ID is invalid");
                cont = true; 
            }
        } while (cont); 
    }
}
