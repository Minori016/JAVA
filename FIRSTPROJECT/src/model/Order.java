/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author xuhoa
 */
public class Order implements Serializable{
    private String orderCode;
    private String customerCode ;
    private String menuId;
    private int numOfTables;
    private String eventDate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.customerCode);
        hash = 59 * hash + Objects.hashCode(this.menuId);
        hash = 59 * hash + Objects.hashCode(this.eventDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.customerCode, other.customerCode)) {
            return false;
        }
        if (!Objects.equals(this.menuId, other.menuId)) {
            return false;
        }
        return Objects.equals(this.eventDate, other.eventDate);
    }
    
    
    // Tao ma don hang duy nhat khong bi trung lap
    private String generateOrderCode() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(now);
        
        
    }
    public Order() {
        this.orderCode = generateOrderCode();
        this.customerCode="";
        this.menuId="";
        this.eventDate="";
    }

    public Order(String customerCode,String menuId, int numOfTables, String eventDate) {
        
        this.customerCode = customerCode;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
        this.orderCode = generateOrderCode(); 
    }   


    public String getOrderCode() {
        return this.orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }




    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNumOfTables() {
        return numOfTables;
        
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }



    @Override
    public String toString() {
        return String.format("%s,%s,,%d,%s ",customerCode,menuId,numOfTables,eventDate);
    }
    
    
    
   

    
}
