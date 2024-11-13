package com.tddforjava.isbntools;

public class StockManager {

    private ISBNDataService webService;
    private ISBNDataService database;
    

    public void setISBNWebService(ISBNDataService service) {
        this.webService = service;
    }

    public void setISBNDatabase(ISBNDataService service) {
        this.database = service;
    }

    public String getLocatorCode(String isbn) {
        Book book = this.database.lookup(isbn);
        if (book == null) book = this.webService.lookup(isbn);
        
        StringBuilder locator = new StringBuilder();
        locator.append(book.getIsbn().substring(isbn.length() - 4));
        locator.append(book.getAuthor().substring(0,1));
        locator.append(book.getTitle().split(" ").length);
        return locator.toString();
    }
    
}

