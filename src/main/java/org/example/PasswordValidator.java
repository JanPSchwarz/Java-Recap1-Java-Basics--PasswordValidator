package org.example;


import java.util.*;

public final class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password Validator program\n");
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        boolean isValid = isValid(password);

        System.out.println("\nYour password is: " + (isValid ? "Valid" : "Invalid"));

        scanner.close();
    }

    // Methods

    public static boolean hasMinLength(String password) {
        return password != null && password.length() >= 8;
    }

    public static boolean hasNoWhiteSpace(String password) {
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsDigit(String password) {
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        char[] chars = password.toCharArray();

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
        }

        return hasUpperCase && hasLowerCase;
    }

    public static boolean isCommonPassword(String password) {
        String[] commonPasswordsArray = {"aa345678", "12345678", "password", "password1", "password1!"};

        final Set<String> commonPasswords = new HashSet<>(Arrays.asList(commonPasswordsArray));

        String normalizedPassword = password.trim().toLowerCase(Locale.ROOT);

        return commonPasswords.contains(normalizedPassword);
    }

    // Bonus method
    public static boolean containsSpecialCharacter(String password, String allowedSpecialChars) {
        if (allowedSpecialChars == null || allowedSpecialChars.isEmpty()) {
            return true;
        }
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (allowedSpecialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;

    }

    public static boolean isValid(String password) {
        String allowedSpecialChars = "!@#$%^&*()-_+=?.,;:";
        boolean hasMinLength = hasMinLength(password);
        boolean hasNoWhiteSpace = hasNoWhiteSpace(password);
        boolean containsDigit = containsDigit(password);
        boolean containsUpperAndLower = containsUpperAndLower(password);
        boolean containsSpecialChar = containsSpecialCharacter(password, allowedSpecialChars);
        boolean isNotCommonPassword = !isCommonPassword(password);

        boolean isValid = hasMinLength && hasNoWhiteSpace && containsDigit && containsUpperAndLower && containsSpecialChar && isNotCommonPassword;

        return isValid;


    }
}