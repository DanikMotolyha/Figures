package com.epam.figure.validator;

public class FigureFileValidator {
    static String validateDouble = "(-?\\d{0,10}(\\.\\d{0,10})? *)+";

    public static boolean validate(String input){
        return input.matches(validateDouble);
    }
}
