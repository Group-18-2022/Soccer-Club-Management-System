package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String emailAddress) {
        EmailValidator validateEmail = EmailValidator.getInstance();
        return validateEmail.isValid(emailAddress);
    }

    public static boolean isNullOrEmpty(Object o)
    {
        return (o == null || o.equals(""));
    }

}
