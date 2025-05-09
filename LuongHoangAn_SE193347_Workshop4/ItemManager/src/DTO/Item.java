/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DTO;

import java.util.Scanner;

/**
 *
 * @author Legion5
 */
public class Item {
    protected int value;        // Khai báo thuộc tính value với kiểu int
    protected String creator;   

    public Item() {
        this.value = 0;
        this.creator = "";
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap gia tri value >0:");
            value=sc.nextInt();
            if(value <=0) {
                System.out.println("Vui long nhap lai:");
                
            }
        } while (value <=0);
        
        
       sc.nextLine();
       do { System.out.println("Nhập tên người tạo:");
       creator = sc.nextLine();
       if ( creator.isEmpty()) {
           System.out.print("Vui long nhap lai:");
       }
       
       } while (creator.isEmpty());
    }
              
        public void output() {
        System.out.println("Giá trị (value): " + value);
        System.out.println("Người tạo (creator): " + creator);
    }
}
   


