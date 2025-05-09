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
public class Vase extends Item{
    private int height;
    private String material;

    public Vase() {
        this.height=0;
        this.material="";
    }

    public Vase(int value, String creator) {
        super(value, creator);
        this.height= height;
        this.material= material;
        
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

   
    public void inputVase(){
        input();
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a height:");
        height=sc.nextInt();
        System.out.println("Input a material:");
        sc=new Scanner(System.in);
        material=sc.nextLine();
        
    }
    public void outputVase(){
        output(); // call the inherited method to print two fields out: value , creator
        System.out.println("Height"+height);
        System.out.println("Material:"+material);
    }
}


