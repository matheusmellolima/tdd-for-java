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
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("1491950358");
        assertTrue(result, "First value: Valid 10 digits ISBN");
        result = validator.checkISBN("1617294543");
        assertTrue(result, "Second value: Valid 10 digits ISBN");
    }

    @Test
    public void checkAValidISBN10EndingWithAnX() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result, "First value: Valid 10 digits ISBN ending with an X");
    }

    @Test
    public void checkAValidISBN13() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("978-1491950357");
        assertTrue(result, "First value: Valid 13 digits ISBN");
        result = validator.checkISBN("978-1617294549");
        assertTrue(result, "Second value: Valid 13 digits ISBN");
    }

    @Test
    public void checkAnInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("14919503589");
        });
    }

    @Test()
    public void nonNumericISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworld");
        });
    }
}
