package part3;

import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        String[] list = new String[10];
        Scanner sc = new Scanner(System.in);  // Khởi tạo Scanner để nhận đầu vào từ bàn phím
        
        // Nhập danh sách tên
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter name " + (i + 1) + ":");
            list[i] = sc.nextLine();
        }
        
        // Chuyển tên thành chữ in hoa
        for (int i = 0; i < 10; i++) {
            list[i] = list[i].toUpperCase();
        }
        
        // In danh sách tên
        System.out.println("List of names in uppercase:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list[i]);
        }
        
        sc.close();  // Đóng Scanner sau khi sử dụng
    }
}
