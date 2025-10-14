package org.example;


public final class PasswordValidator {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Methods

    public static boolean hasMinLength(String password) {
        return password != null && password.length() >= 8;
    }

    public static boolean containsDigit(String password) {
        return true;
    }

    public static boolean containsUpperAndLower(String password) {
        return true;
    }

    public static boolean isCommonPassword(String password) {
        return true;
    }

    // Bonus methods
    public static boolean containsSpecialCharacter(String password) {
        return true;
    }

    public static boolean isValid(String password) {
        return true;
    }
}