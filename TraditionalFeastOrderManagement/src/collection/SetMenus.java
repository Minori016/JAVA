/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.util.ArrayList;
import model.SetMenu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.text.DecimalFormat;

/**
 *
 * @author xuhoa
 */
public class SetMenus implements Serializable {
    public static ArrayList<SetMenu> setMenuList = new ArrayList<>();
   
    public SetMenu dataToObject(String line) {
        
        String [] splitData = line.split(",",-1);
        if (splitData.length >3) {
            
            String menuId=splitData[0].trim();
            String menuName=splitData[1].trim();
            double price=Double.parseDouble(splitData[2].trim()); 
            String ingredients=splitData[3].trim();
            
            return new SetMenu(menuId, menuName, price, ingredients);
        } else {
        
            return null;
         }
    
}
    public  ArrayList<SetMenu> readFromFile() {
    String locateFile = "src/data/FeastMenu.csv";
    try (BufferedReader x = new BufferedReader(new FileReader(locateFile))) {
        String line = x.readLine();
        while ((line = x.readLine())!=null) {
            SetMenu menuSet = dataToObject(line);
            if(menuSet!=null) {
                setMenuList.add(menuSet);
            }
        }
    } catch (IOException e ) {
        System.out.println("Cant read data form feastMenu.csv!!! . Please check");
      
    }
    Collections.sort(setMenuList);
    return setMenuList; 
    }
    
     public void showAllMenu() {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("            List of Set Menu List you can use for ordering your party!!               ");
            System.out.println("--------------------------------------------------------------------------------------");
            for (SetMenu x : setMenuList) { 
            System.out.println("menuId             : "+x.getMenuId());
            System.out.println("menuName           : "+x.getMenuName());
            System.out.println("Price              : "+formatPrice(x.getPrice()));
            System.out.println("Ingredients        :\n"+splitFoodFormat(x.getIngredients()));
            System.out.println("--------------------------------------------------------------------------------------");
            }
        
    }
     
     public static String splitFoodFormat(String splitMeal) {
         splitMeal = splitMeal.replaceAll("\"", "" ) ;
         splitMeal = splitMeal.replaceAll("\\#", "\n");
         return splitMeal;
     }
     
     public static String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(price);
}

    }