package com.tddforjava.isbntools;

public class ISBN {

    IValidateISBN validator;
    String isbn;

    public ISBN(String isbn) {
        this.isbn = isbn;
    }

    public boolean isValid() {
        return this.validator.checkISBN(this.isbn);
    }
    
}
