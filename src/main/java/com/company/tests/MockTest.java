package main.java.com.company.tests;

import main.java.com.company.lab1.*;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MockTest {

    @Test
    public void searchReaderById_Compare_IdTicket(){
        Library library = new Library();
        Reader reader = Mockito.mock(Reader.class);
        Book b = Mockito.mock(Book.class);
        Librarian l = Mockito.mock(Librarian.class);
        library.setReaders(reader);

        when(reader.getIdTicket()).thenReturn(10);

        int act = library.searchReaderById(10).getIdTicket();

        assertEquals(act, 10);
    }

    @Test
    public void deleteRecord_Remove_From() {
        Library library = Mockito.mock(Library.class);

        Reader r =Mockito.mock(Reader.class);
        Book b =Mockito.mock(Book.class);
        Librarian l = Mockito.mock(Librarian.class);

        library.setRecord(r, b, l);
        library.deleteRecord(r, 0);

    }
}