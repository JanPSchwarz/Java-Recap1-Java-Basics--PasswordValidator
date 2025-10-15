package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldReturnTrue_withLength9() {
        String hasLength9 = "password1";
        boolean actual = PasswordValidator.hasMinLength(hasLength9);
        assertTrue(actual);
    }

    @Test
    void hasMinLength_shouldReturnTrue_withLength8() {
        String hasLength8 = "password";
        boolean actual = PasswordValidator.hasMinLength(hasLength8);
        assertTrue(actual);
    }

    @Test
    void hasMinLength_shouldReturnFalse_withLength7() {
        String hasLength7 = "passwor";
        boolean actual = PasswordValidator.hasMinLength(hasLength7);
        assertFalse(actual);
    }

    @Test
    void hasMinLength_shouldReturnFalse_withEmptyString() {
        String emptyString = "";
        boolean actual = PasswordValidator.hasMinLength(emptyString);
        assertFalse(actual);
    }

    @Test
    void hasMinLength_shouldReturnFalse_withNull() {
        boolean actual = PasswordValidator.hasMinLength(null);
        assertFalse(actual);
    }

    @Test
    void hasNoWhiteSpace_shouldReturnTrue_withNoWhiteSpace() throws Exception {
        String hasNoWhiteSpace = "hasNoWhiteSpace";
        boolean actual = PasswordValidator.hasNoWhiteSpace(hasNoWhiteSpace);
        assertTrue(actual);
    }

    @Test
    void hasNoWhiteSpace_shouldReturnFalse_withWhiteSpace() throws Exception {
        String hasWhiteSpace = "has white space";
        boolean actual = PasswordValidator.hasNoWhiteSpace(hasWhiteSpace);
        assertFalse(actual);
    }

    @Test
    void hasNoWhiteSpace_shouldReturnFalse_withWhiteSpaceNewLine() throws Exception {
        String hasWhiteSpace = "has \nwhite\n space";
        boolean actual = PasswordValidator.hasNoWhiteSpace(hasWhiteSpace);
        assertFalse(actual);
    }

    @Test
    void containsDigit_shouldReturnTrue_forPasswordWithDigit() {
        String password = "password1";
        boolean actual = PasswordValidator.containsDigit(password);
        assertTrue(actual);
    }

    @Test
    void containsDigit_shouldReturnFalse_forPasswordWithOutDigit() {
        String password = "password";
        boolean actual = PasswordValidator.containsDigit(password);
        assertFalse(actual);
    }

    @Test
    void containsDigit_shouldReturnTrue_forPasswordWitOnlyDigits() {
        String password = "123789";
        boolean actual = PasswordValidator.containsDigit(password);
        assertTrue(actual);
    }

    @Test
    void containsDigit_shouldReturnTrue_forPasswordWithManyDigits() {
        String password = "pw123789";
        boolean actual = PasswordValidator.containsDigit(password);
        assertTrue(actual);
    }

    @Test
    void containsUpperAndLower_shouldReturnTrue_forPasswordWithUpperAndLower() {
        String upperAndLowerCase = "Password1";
        boolean actual = PasswordValidator.containsUpperAndLower(upperAndLowerCase);
        assertTrue(actual);
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_forPasswordWithOnlyUpper() {
        String onlyUpperCase = "PASSWORD";
        boolean actual = PasswordValidator.containsUpperAndLower(onlyUpperCase);
        assertFalse(actual);
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_forPasswordWithOnlyLower() {
        String onlyLowerCase = "password1";
        boolean actual = PasswordValidator.containsUpperAndLower(onlyLowerCase);
        assertFalse(actual);
    }

    @Test
    void isCommonPassword() {
    }

    @Test
    void containsSpecialCharacter() {
    }

    @Test
    void isValid() {
    }
}