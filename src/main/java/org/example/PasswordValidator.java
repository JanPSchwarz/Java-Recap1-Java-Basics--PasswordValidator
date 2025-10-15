package org.example;


import java.util.*;

public final class PasswordValidator {

    private static final String ALLOWED_SPECIAL_CHARS = "!@#$%^&*()-_+=?.,;:";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Password Validator program\n");

        boolean hasValidPassword = false;

        while (!hasValidPassword) {
            System.out.println("\nWould you like to generate a Password(1) or try our own password(2)? Enter a number: ");
            String option = scanner.nextLine();

            if ("1".equals(String.valueOf(option))) {

                System.out.println("\nEnter a Password length (8-20): ");

                int length = scanner.nextInt();

                int normalizedLength = length < 8 ? 8 : Math.min(length, 20);

                String newPassword = generateStrongPassword(normalizedLength);

                System.out.println("\nNew Password: " + newPassword);

                hasValidPassword = true;
            } else if ("2".equals(String.valueOf(option))) {
                System.out.println("\nEnter a password: ");

                String password = scanner.nextLine();

                boolean isValid = isValid(password);

                if (!isValid) {

                    System.out.println("\nPassword is invalid!");

                    System.out.println("\nPassword report:\n");

                    reportValidation(password);
                } else {
                    hasValidPassword = true;
                }

            } else {
                System.out.println("\nPlease enter a valid option!");
                option = scanner.nextLine();
            }

        }

        System.out.println("\nPassword valid!");

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
        boolean hasMinLength = hasMinLength(password);
        boolean hasNoWhiteSpace = hasNoWhiteSpace(password);
        boolean containsDigit = containsDigit(password);
        boolean containsUpperAndLower = containsUpperAndLower(password);
        boolean containsSpecialChar = containsSpecialCharacter(password, ALLOWED_SPECIAL_CHARS);
        boolean isNotCommonPassword = !isCommonPassword(password);

        return hasMinLength && hasNoWhiteSpace && containsDigit && containsUpperAndLower && containsSpecialChar && isNotCommonPassword;
    }

    public static void reportValidation(String password) {
        StringBuilder report = new StringBuilder();

        // Header
        report.append(String.format("%-40s %s%n", "Requirement", "Passed"));
        report.append("-".repeat(50)).append("\n");

        addTableRow(report, "Minimum length (8 characters)", hasMinLength(password));
        addTableRow(report, "No whitespace", hasNoWhiteSpace(password));
        addTableRow(report, "At least 1 digit", containsDigit(password));
        addTableRow(report, "Upper and lowercase letters", containsUpperAndLower(password));
        addTableRow(report, "At least 1 special character", containsSpecialCharacter(password, ALLOWED_SPECIAL_CHARS));
        addTableRow(report, "Not a common password", !isCommonPassword(password));

        System.out.println(report);
    }

    private static void addTableRow(StringBuilder report, String requirement, boolean passed) {
        String status = passed ? "✓ Yes" : "✗ No";
        report.append(String.format("%-40s %s%n", requirement, status));
    }

    public static String generateStrongPassword(int length) {


        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        String allChars = uppercase + lowercase + digits + ALLOWED_SPECIAL_CHARS;

        boolean isValid = false;
        String strongPassword = "";
        int count = 0;

        Random random = new Random();


        while (!isValid) {
            char[] chars = new char[length];

            for (int i = 0; i < length; i++) {
                int randomInt = random.nextInt(allChars.length());
                chars[i] = allChars.charAt(randomInt);
            }

            strongPassword = new String(chars);
            isValid = isValid(strongPassword);
            count++;
        }

        System.out.println("\nLooped for " + count + " iterations!");

        return strongPassword;
    }
}