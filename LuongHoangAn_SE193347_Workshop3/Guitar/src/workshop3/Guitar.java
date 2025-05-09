/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workshop3;

/**
 *
 * @author Legion5
 */

public class Guitar {
    private String SerialNumber;
    private int Price;
    private String Model;
    private String Builder;
    private String BackWood;
    private String TopWood;
    
    public Guitar(){
    this.SerialNumber="";
    this.Price =0;
    this.Model ="";
    this.Builder="";
    this.BackWood="";
    this.TopWood="";
            
    
    
}
    public Guitar(String SerialNumber, int Price, String Model, String Builder, String BackWood, String TopWood) {
        this.SerialNumber = SerialNumber;
        this.Price = Price;
        this.Model = Model;
        this.Builder = Builder;
        this.BackWood = BackWood;
        this.TopWood = TopWood;
    }



    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
        public void setModel(String Model) {
        this.Model = Model;
    }

    public String getModel() {
        return Model;
    }

    public String getBuilder() {
        return Builder;
    }

    public void setBuilder(String Builder) {
        this.Builder = Builder;
    }

    public String getBackWood() {
        return BackWood;
    }

    public void setBackWood(String BackWood) {
        this.BackWood = BackWood;
    }

    public String getTopWood() {
        return TopWood;
    }

    public void setTopWood(String TopWood) {
        this.TopWood = TopWood;
    }
    public void createSound() {
        
    System.out.println("SerialNumber:"+ getSerialNumber());
    System.out.println("Price:"+getPrice());
    System.out.println("Builder:"+getBuilder());
    System.out.println("Model:"+getModel());
    System.out.println("BackWood:"+getBackWood());
    System.out.println("TopWood:"+getTopWood());
}
    
    


}
