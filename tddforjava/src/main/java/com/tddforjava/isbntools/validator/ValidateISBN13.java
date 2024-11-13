package com.tddforjava.isbntools.validator;

public class ValidateISBN13 implements IValidateISBN {

    @Override
    public boolean checkISBN(String isbn) {
        isbn = isbn.replace("-", "");
        if (!ValidateISBN13.isISBN(isbn)) {
            throw new NumberFormatException("ISBN-13 should contain 13 digits");
        }
        
        int total = 0;
        for (int i = 0; i < 13; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                throw new NumberFormatException("ISBN should contain only digits");
            }

            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }
        return total % 10 == 0;
    }

    public static boolean isISBN(String isbn) {
        return isbn.replace("-", "").length() == 13;
    }

}
