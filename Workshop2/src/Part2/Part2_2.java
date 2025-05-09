/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Part2;

import java.util.Scanner;

public class Part2_2 {
    public String inputStudentID() throws Exception {
        String pattern = "[S][E]\\d{6}"; 
        String StudentID = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("input the Student ID:");
        StudentID = sc.nextLine();
        if (!StudentID.matches(pattern)) {
            throw new Exception();
        }
        return StudentID;
    }

    public static void main(String[] args) {
        Part2_2 obj = new Part2_2();
        boolean cont = false;
        do {
            try {
                String StudentID = obj.inputStudentID();
                System.out.println("The Student ID is " + StudentID);
                cont = false;
            } catch (Exception e) {
                System.out.println("The Student ID is invalid");
                cont = true;
            }
        } while (cont);
    }
}
