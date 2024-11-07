package com.tddforjava.isbntools;

public class ValidateISBN10 implements IValidateISBN {

    @Override
    public boolean checkISBN(String isbn) {
        if (!ValidateISBN10.isISBN(isbn)) {
            throw new NumberFormatException("ISBN-10 should contain 10 digits");
        }

        int total = 0;
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                throw new NumberFormatException("ISBN should contain only digits");
            }
            total += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }
        return total % 11 == 0;
    }

    public static boolean isISBN(String isbn) {
        return isbn.length() == 10;
    }

}
