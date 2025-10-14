package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PasswordValidatorTest {

    @Test
    void hasMinLength_shouldReturnTrue_withLength9() {
        String hasLength8 = "password1";
        boolean actual = PasswordValidator.hasMinLength(hasLength8);
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
        String hasLength8 = "passwor";
        boolean actual = PasswordValidator.hasMinLength(hasLength8);
        assertFalse(actual);
    }

    @Test
    void hasMinLength_shouldReturnFalse_withEmptyString() {
        String hasLength8 = "";
        boolean actual = PasswordValidator.hasMinLength(hasLength8);
        assertFalse(actual);
    }

    @Test
    void containsDigit() {
    }

    @Test
    void containsUpperAndLower() {
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