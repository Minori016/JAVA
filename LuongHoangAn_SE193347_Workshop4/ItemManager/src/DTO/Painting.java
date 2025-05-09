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
public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
        this.height = 0;
        this.width = 0;
        this.isWatercolour=false;
        this.isFramed=false;
    }

    public Painting(int value, String creator) {
        super(value, creator);
        this.height= height;
        this.width=width;
        this.isWatercolour= isWatercolour;
        this.isFramed= isFramed;
        
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }
    
     public void inputPainting() {
        // Gọi hàm input() của lớp cha để nhập value và creator
        input();

        Scanner sc = new Scanner(System.in);

        // Nhập các thuộc tính riêng của Painting
        System.out.print("Nhập chiều cao (height): ");
        height = sc.nextInt();

        System.out.print("Nhập chiều rộng (width): ");
        width = sc.nextInt();

        System.out.print("Có phải tranh màu nước không (true/false): ");
        isWatercolour = sc.nextBoolean();

        System.out.print("Tranh có khung không (true/false): ");
        isFramed = sc.nextBoolean();
    }
     public void outputPainting() {
        // Gọi hàm output() của lớp cha để in value và creator
        output();

        // In các thuộc tính riêng của Painting
        System.out.println("Chiều cao: " + height);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Là tranh màu nước: " + isWatercolour);
        System.out.println("Có khung: " + isFramed);
    }
}

