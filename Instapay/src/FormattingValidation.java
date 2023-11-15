import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormattingValidation {
    static public boolean checkPassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    static public boolean checkMobileNumber(String mobileNumber) {
        String mobileNumberPattern = "^(012|011|010|015)\\d{8}$";
        Pattern pattern = Pattern.compile(mobileNumberPattern);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
}
