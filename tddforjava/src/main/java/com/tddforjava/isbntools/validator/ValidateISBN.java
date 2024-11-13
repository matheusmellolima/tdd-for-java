package com.tddforjava.isbntools.validator;

public class ValidateISBN implements IValidateISBN {

    public IValidateISBN getValidator(String isbn) {
        if (ValidateISBN10.isISBN(isbn)) {
            return new ValidateISBN10();
        } else if (ValidateISBN13.isISBN(isbn)) {
            return new ValidateISBN13();
        }

        throw new NumberFormatException("ISBN should be either one of the following formats: ISBN-10, ISBN-13");
    }

    @Override
    public boolean checkISBN(String isbn) {
        IValidateISBN validator = this.getValidator(isbn);
        return validator.checkISBN(isbn);
    }
    
}
