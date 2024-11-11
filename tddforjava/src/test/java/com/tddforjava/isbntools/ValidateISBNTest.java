package com.tddforjava.isbntools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    // Valid ISBNs
    // ISBN-10: 1491950358
    // ISBN-13: 978-1491950357

    // ISBN-10: 1617294543
    // ISBN-13: 978-1617294549

    @Test
    public void checkAValidISBN10() {
        // Valid 10 digits ISBNs made up of numbers only
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("1491950358");
        assertTrue(result, "First value: Valid ISBN-10");
        result = validator.checkISBN("1617294543");
        assertTrue(result, "Second value: Valid ISBN-10");
    }

    @Test
    public void checkAValidISBN10EndingWithAnX() {
        // Valid 10 digits ISBNs that end in an X
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result, "First value: Valid ISBN-10 ending with an X");
    }

    @Test
    public void invalidISBN10Digits() {
        // Invalid 10 digit ISBNs made up of numbers only
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("14919503589");
        });
    }

    @Test
    public void invalidISBN10DigitsEndingWithAnX() {
        // Invalid 10 digit ISBNs that end in an X
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000430X");
        assertFalse(result, "First value: Invalid ISBN-10 ending with an X");
    }

    @Test()
    public void nonNumericISBN10AreNotAllowed() {
        // Invalid 10 digit ISBNs that aren't numeric
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworld");
        });
    }

    @Test
    public void checkAValidISBN13() {
        // Valid 13 digits ISBNs
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("978-1491950357");
        assertTrue(result, "First value: Valid ISBN-13");
        result = validator.checkISBN("978-1617294549");
        assertTrue(result, "Second value: Valid ISBN-13");
    }

    @Test
    public void invalidISBN13Digits() {
        // Invalid 13 digit ISBNs made up of numbers only
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("978-1617294541");
        assertFalse(result, "First value: Invalid ISBN-13");
    }

    @Test()
    public void nonNumericISBN13AreNotAllowed() {
        // Invalid 13 digit ISBNs that aren't numeric
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworldthi");
        });
    }

    @Test()
    public void ISBNshouldBe10Or13Formats() {
        // Invalid ISBN that aren't 10 or 13 digits
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("149195035");
        });
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("14919503599");
        });
    }

}
