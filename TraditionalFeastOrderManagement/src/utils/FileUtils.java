package utils;

import collection.Customers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuhoa
 */
public class FileUtils {
    public static <T> List<T> readFromFile(String filePath) {
        List<T> result = new ArrayList<>();
        FileInputStream fis = null;
        try {
            //--- 1. Tạo File object để ánh xạ lên thiết bị --------------------
            File f = new File(filePath);
            if (!f.exists()) {
                System.out.println("File not found !.\"" + filePath + "\"");
                return result; // Trả về danh sách rỗng nếu file không tồn tại
            }
            //--- 2. Tạo luồng ánh xạ tới file để đọc dữ liệu từ thiết bị ----
            fis = new FileInputStream(f);
            //--- 3. Tạo đối tượng mang dữ liệu từ luồng đã tạo ở trên --------
            ObjectInputStream ois = new ObjectInputStream(fis);
            //--- 4. Lặp và đọc dữ liệu từ file, gán vào đối tượng hiện hành khi còn dữ liệu
           
            
            while (fis.available() > 0) { 
                T x = (T) ois.readObject();
                result.add(x);
            }
            //--- 5. Đóng đối tượng, sau khi đọc xong
            ois.close(); // Nên đóng trong try-with-resources hoặc finally
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) { // Kiểm tra fis trước khi đóng
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

 
    public static <T> void saveToFile(List<T> li, String filePath) {
        FileOutputStream fos = null;
        try {
            //--- 1. Tạo File object
            File f = new File(filePath);
            //--- 2. Tạo FileOutputStream Ánh xạ tới File object
            fos = new FileOutputStream(f);
            //--- 3. Tạo ObjectOutputStream để chuyển dữ liệu xuống thiết bị
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //--- 4. Lặp để ghi dữ liệu
            for (T i : li) {
                oos.writeObject(i);
            }
            //--- 5. Đóng các object tương ứng sau khi xử lý
            oos.close(); 
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fos != null) { 
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
} 