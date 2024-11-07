package com.tddforjava.isbntools;

public class ValidateISBN implements IValidateISBN {

    public IValidateISBN getValidator(String isbn) {
        IValidateISBN validator;
        if (ValidateISBN10.isISBN(isbn)) {
            validator = new ValidateISBN10();
        } else if (ValidateISBN13.isISBN(isbn)) {
            validator = new ValidateISBN13();
        } else {
            throw new NumberFormatException("ISBN should be either one of the following formats: ISBN-10, ISBN-13");
        }
        return validator;
    }

    @Override
    public boolean checkISBN(String isbn) {
        IValidateISBN validator = this.getValidator(isbn);
        return validator.checkISBN(isbn);
    }
    
}
