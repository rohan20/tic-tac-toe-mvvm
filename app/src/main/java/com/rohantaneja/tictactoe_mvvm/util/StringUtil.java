package com.rohantaneja.tictactoe_mvvm.util;

/**
 * Created by rohantaneja on 05/04/18.
 */

public class StringUtil {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().length() == 0 || s.equalsIgnoreCase("null");
    }

    public static String stringFromNumbers(int... numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int number : numbers)
            stringBuilder.append(number);

        return stringBuilder.toString();
    }


}
