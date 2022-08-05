package za.ac.cput.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String emailAddress){
        EmailValidator validateEmail = EmailValidator.getInstance();
        return validateEmail.isValid(emailAddress);
    }

    public static boolean isEmptyOrNull(String s) {
        return StringUtils.isEmpty(s);
    }

    public static void checkStringParam(String paramName, String paramValue) {
        if(isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(
                    String.format("Invalid value for params: %s", paramName)
            );
    }
}
