
package utils;

/**
 *
 * @author xuhoa
 */
public interface Acceptable {
   public final String CODE_VALID = "[CcGgKk]\\{4}$";
   public final String NAME_VALID = "^.{2,25}$";
   public final String EMAIL_VALID = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
   public final String PHONE_VALID ="^0\\d{9}$";
   public final String MENUCODE_VALID ="^[FfWw](00[1-6])$";
   
        public static boolean isValid(String data, String pattern) {
        return data.matches(data);
    }
   
  }


   

// Phan ten nguoi dung: Co the chua chu cai (a-z, A-Z), chu so (0-9), va cac ky tu dac biet nhu dau cong (+), gach duoi (_), dau cham (.), hoac gach ngang (-). Phai co it nhat mot ky tu.
// Ky tu @: Bat buoc phai co de phan tach ten nguoi dung va ten mien.
// Phan ten mien: Tuong tu ten nguoi dung, co the chua chu cai, chu so, dau cham (.), hoac gach ngang (-). Phai co it nhat mot ky tu.
// Dau cham .: Bat buoc phai co de phan tach ten mien va ten mien cap cao nhat (TLD).