package com.tddforjava.isbntools;

public class StockManager {

    private ExternalISBNDataService isbnDataService;

    

    public void setISBNDataService(ExternalISBNDataService service) {
        this.isbnDataService = service;
    }

    public String getLocatorCode(String isbn) {
        Book book = this.isbnDataService.lookup(isbn);
        StringBuilder locator = new StringBuilder();
        locator.append(book.getIsbn().substring(isbn.length() - 4));
        locator.append(book.getAuthor().substring(0,1));
        locator.append(book.getTitle().split(" ").length);
        return locator.toString();
    }
    
}

