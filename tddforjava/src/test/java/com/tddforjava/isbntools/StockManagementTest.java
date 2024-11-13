package com.tddforjava.isbntools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StockManagementTest {

    @Test
    public void canGetACorrectLocatorCode() {

        ISBNDataService webService = new ISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
            }
        };

        ISBNDataService database = new ISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setISBNWebService(webService);
        stockManager.setISBNDatabase(database);

        String ibsn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(ibsn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        ISBNDataService database = mock(ISBNDataService.class);
        ISBNDataService webService = mock(ISBNDataService.class);
        when(database.lookup("0140177396")).thenReturn(new Book("0140177396", "ABC", "ABC"));

        StockManager stockManager = new StockManager();
        stockManager.setISBNWebService(webService);
        stockManager.setISBNDatabase(database);

        String ibsn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(ibsn);
        // assertEquals("7396J4", locatorCode);
        verify(database, times(1)).lookup("0140177396");
        verify(webService, times(0)).lookup(anyString());
    }    

    @Test
    public void databaseIsUsedIfDataIsPresentInDatabase() {
        ISBNDataService database = mock(ISBNDataService.class);
        ISBNDataService webService = mock(ISBNDataService.class);
        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "ABC", "ABC"));
        when(database.lookup("0140177396")).thenReturn(null);

        StockManager stockManager = new StockManager();
        stockManager.setISBNWebService(webService);
        stockManager.setISBNDatabase(database);

        String ibsn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(ibsn);
        // assertEquals("7396J4", locatorCode);
        verify(webService, times(1)).lookup("0140177396");
        verify(database, times(1)).lookup("0140177396");
    }    
    
}