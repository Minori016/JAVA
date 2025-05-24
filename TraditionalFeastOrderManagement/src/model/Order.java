/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author xuhoa
 */
public class Order implements Serializable{
    private String orderCode;
    private String customerCode ;
    private String province;
    private String menuId;
    private int numOfTables;
    private Date eventDate;
    
    
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
        this.eventDate= new Date();
    }
    
     public Order(String customerId, String province, String menuId, int numOfTables, Date eventDate) {
        this.orderCode = generateOrderCode();
        this.customerCode = customerId;
        this.province = province;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
    }

    public String getOrderCode() {
        return orderCode;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%s ",customerCode,menuId,eventDate);
    }
    
    
    
   

    
}
