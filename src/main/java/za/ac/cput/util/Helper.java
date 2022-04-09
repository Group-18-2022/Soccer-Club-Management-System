package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isEmpty(String value) {
        return value.equals("");
    }
}
