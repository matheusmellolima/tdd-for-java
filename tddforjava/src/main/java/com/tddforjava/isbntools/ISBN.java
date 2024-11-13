package com.tddforjava.isbntools;

import com.tddforjava.isbntools.validator.IValidateISBN;
import com.tddforjava.isbntools.validator.ValidateISBN;

public class ISBN {

    IValidateISBN validator;
    String isbn;

    public ISBN(String isbn) {
        this.isbn = isbn;
        this.validator = new ValidateISBN();
    }

    public boolean isValid() {
        return this.validator.checkISBN(this.isbn);
    }
    
}
