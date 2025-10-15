package org.example;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class PasswordValidator {

    public static void main(String[] args) {
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
        String[] commonPasswordsArray = {"aa345678", "12345678", "password", "password1"};

        final Set<String> commonPasswords = new HashSet<>(Arrays.asList(commonPasswordsArray));

        String normalizedPassword = password.trim().toLowerCase(Locale.ROOT);

        return commonPasswords.contains(normalizedPassword);
    }

    // Bonus method
    public static boolean containsSpecialCharacter(String password, String allowedSpecialChars) {
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (allowedSpecialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;

    }

    public static boolean isValid(String password) {
        boolean hasMinLength = hasMinLength(password);
        boolean hasNoWhiteSpace = hasNoWhiteSpace(password);
        boolean containsDigit = containsDigit(password);
        boolean containsUpperAndLower = containsUpperAndLower(password);
        boolean isNotCommonPassword = !isCommonPassword(password);

        boolean isValid = hasMinLength && hasNoWhiteSpace && containsDigit && containsUpperAndLower && isNotCommonPassword;

        return isValid;


    }
}