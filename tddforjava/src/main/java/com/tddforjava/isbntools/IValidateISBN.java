package com.tddforjava.isbntools;

public interface IValidateISBN {

    boolean checkISBN(String isbn);

    static boolean isISBN(String isbn) {
        throw new UnsupportedOperationException("Method isISBN() not implemented");
    }

}
