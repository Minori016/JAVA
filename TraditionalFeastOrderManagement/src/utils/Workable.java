/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

/**
 *
 * @author xuhoa
 */
public interface Workable<T> {
        void addNew();
        void update();
        T searchById(String code);
        void readFromFile();
        void saveFromeFile();
        void showAll();
                
}