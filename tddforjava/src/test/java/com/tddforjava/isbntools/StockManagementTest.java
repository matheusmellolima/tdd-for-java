package com.tddforjava.isbntools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StockManagementTest {

    @Test
    public void canGetACorrectLocatorCode() {

        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
            }
        };

        String ibsn = "0140177396";
        StockManager stockManager = new StockManager();
        stockManager.setISBNDataService(testService);
        String locatorCode = stockManager.getLocatorCode(ibsn);
        assertEquals("7396J4", locatorCode);
    }            
}