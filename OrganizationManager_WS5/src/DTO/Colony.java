/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Legion5
 */
public class Colony extends Organization {
    protected String place; 

    public Colony() {
        this.place="";
    }

    public Colony(int size, String place) {
        super(size);
        
        this.place= place;
    }
    @Override
    public  void  communicateByTool() {
        System.out.println("the colony communicate by sound");
    }
    
    public void grow() {
        System.out.println("an annual cycle of growth that begins in spring" );

    }
    public void reproduce() {
        System.out.println("Colony can reproduce itself through a process");       
    }

    @Override
    public String toString() {
        return "the colony size is" + size +","+"the colony’s place is" + place;
    }
    
    

}
