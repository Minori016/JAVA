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
public class Statue extends Item {
    private int weight;
    private String colour;

    public Statue() {
        this.weight=0;
        this.colour="";
    }

    public Statue(int value, String creator) {
        super(value, creator);
        this.value = weight;
        this.colour= colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

   
     public void inputStatue(){
        input();
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a weight:");
        weight=sc.nextInt();
        System.out.println("Input a colour:");
        sc=new Scanner(System.in);
        colour=sc.nextLine();
        
    }
    public void outputStatue(){
        output(); // call the inherited method to print two fields out: value , creator
        System.out.println("Weight:"+weight);
        System.out.println("Colour:"+colour);
    }
    
}
