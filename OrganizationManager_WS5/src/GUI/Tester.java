package GUI;

import DTO.BeeColony;
import DTO.FPTUniversity;
import DTO.Colony;
import DTO.University;
import DTO.Role;

public class Tester {

    public static void main(String[] args) {
        // Tạo đối tượng từ lớp BeeColony
        Colony obj1 = new BeeColony(2000, "honey", "land");
        System.out.println(obj1.toString());
        obj1.grow();
        obj1.reproduce();
        System.out.println("-------------------------------------------------------------");
        // Tạo đối tượng từ lớp FPTUniversity
        University obj2 = new FPTUniversity(100000, "FPT", "Cantho");
        System.out.println(obj2.toString());
        obj2.enroll();
        obj2.educate();
        System.out.println("-------------------------------------------------------------");
        // Sử dụng giao diện Role để tạo đối tượng BeeColony
        Role role = new BeeColony(3000, "wasp", "land");
        System.out.println(role.toString());
        role.createWorker();
        System.out.println("-------------------------------------------------------------");
        // Sử dụng giao diện Role để tạo đối tượng FPTUniversity
        role = new FPTUniversity(100000, "FPT", "Hanoi");
        System.out.println(role.toString());
        role.createWorker();
    }
}
