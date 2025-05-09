/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carmanager;

/**
 *
 * @author Legion5
 */
public class Car {
    
    private String Colour;
    private int EnginePower;
    private boolean Convertible; 
    private boolean ParkingBrake;
    
   
    public Car (){
    this.Colour="";
    this.EnginePower =0;
    this.Convertible =false;
    this.ParkingBrake=false;
    
    
}

    public Car( String Colour, int EnginePower, boolean Convertible, boolean ParkingBrake) {
        
        this.Colour = Colour;
        this.EnginePower = EnginePower;
        this.Convertible = Convertible;
        this.ParkingBrake = ParkingBrake;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public String getColour() {
        return Colour;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public boolean isParkingBrake() {
        return ParkingBrake;
    }

    public void setEnginePower(int EnginePower) {
        this.EnginePower = EnginePower;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public void setParkingBrake(boolean ParkingBrake) {
        this.ParkingBrake = ParkingBrake;
    }
    
    public void pressStartButton() {
    System.out.println("You have pressed the start button");
}
    public void pressAcceleratorButton() {
        System.out.println("You have pressed the Accelerator button");
    }
    public void output() {
    System.out.println("Colour: " + this.Colour);
    System.out.println("Engine Power: " + this.EnginePower);
    System.out.println("Convertible: " + this.Convertible);
    System.out.println("Parking Brake: " + this.ParkingBrake);
}   
    

}