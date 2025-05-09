package Part1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Legion5
 */
import java.util.Scanner;
public class Part1 {
    public static void main(String[] args) {
        boolean cont=false;
        do  {
            try {
                int number;
                Scanner sc = new Scanner(System.in) ;
                System.out.println("enter number:");
                number=sc.nextInt();
                if (number<1)
                    throw new Exception();
                System.out.println("The number is "+number);
                cont=false;
                
                
            }
            catch (Exception e) {
                System.out.println("The number is invalid");
                cont=true;
                
            }
        } while(cont);
    }
    
}
