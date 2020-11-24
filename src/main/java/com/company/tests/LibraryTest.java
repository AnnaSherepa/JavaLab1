package main.java.com.company.tests;

import main.java.com.company.lab1.*;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class LibraryTest {
    private static Library library;
    private static Reader reader;
    private static Author author1, author2, author3;
    private static Librarian librarian;
    private static Book book1, book2;

    @BeforeClass
    public static void setUp(){
        library = new Library();
        reader = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        author1 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        author2 = new Author("Іван", "Франко", "Якович", 60, Sex.man, 1874,1916);
        author3 = new Author("Леся", "Українка","Петрівна", 47, Sex.woman, 1840, 1861);
        librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        book1 = new Book("Перебендя", author1, 3, Type.teacher);
        book2 = new Book("Кобзар", author1, 1, Type.teacher);

        library.setAuthors(author1);
        library.setAuthors(author2);
        //library.setAuthors(author3);

        library.setBooks(book2);
        //library.setBooks(book1);
        library.setLibrarians(librarian);

        library.setReaders(reader);

    }
    @Test
    public void searchLibrarianById_Get_Librarian() {
        Librarian actual = library.searchLibrarianById(0);
        Assert.assertEquals(librarian, actual);
    }

    @Test
    public void searchBookByName_Get_Book() {
        Book actual = library.searchBookByName("Кобзар");
        Assert.assertEquals(book2, actual);

    }
    @Test
    public void searchBookByName_Return_NULL() {
        Book actual = library.searchBookByName("Перебендя");
        Assert.assertNull(actual);
    }

    @Test
    public void searchAuthorBySurname_Get_Author() {
        Author actual = library.searchAuthorBySurname("Шевченко");
        Assert.assertEquals(actual, author1);
    }


    @Test
    public void searchAuthorBySurname_Return_NULL() {
        Author actual = library.searchAuthorBySurname("Українка");
        Assert.assertNull(actual);
    }

    @Test
    public void searchLibrarianById_Return_NULL() {
        Librarian actual = library.searchLibrarianById(-1);
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderByName_Get_Reader() {
        Reader actual = library.searchReaderByName("Анна");
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderByName_Return_NULL() {

        Reader actual = library.searchReaderByName("Марія");
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderById_Return_Reader() {
        Reader actual = library.searchReaderById(0);
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderById_Return_NULL() {
        Reader actual = library.searchReaderById(-1);
        Assert.assertNull(actual);
    }


    @Test
    public void showListOfBooks_Show() {
        library.setBooks(book2);

        library.showListOfBooks();
    }

    @Test
    public void showListOfBooks_Show_NULL_list() {
        Library l = new Library();
        l.showListOfBooks();
    }

    @Test
    public void showListOfAuthors_Show() {
        library.showListOfAuthors();
    }


    @Test
    public void showListOfAuthors_Show_NULL() {
        Library l = new Library();
        l.showListOfAuthors();
    }

    @Test
    public void showListOfReaders_Show() {
        library.setReaders(reader);
        library.showListOfReaders();
    }


    @Test
    public void showListOfReaders_Show_NULL_list() {
        Library l = new Library();
        l.showListOfReaders();
    }


    @Test
    public void showListOfLibrarian_Show() {
        library.showListOfLibrarian();
    }


    @Test
    public void showListOfLibrarian_Show_NULL() {
        Library l = new Library();
        l.showListOfLibrarian();
    }

    @Test
    public void setRecord_Add_To_Library() {
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
    }

    @Test
    public void deleteRecord_Remove_From_Library() {
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
        Reader r = library.getReaders().get(0);
        r.show(true);
        library.deleteRecord(library.searchReaderById(0), 0);
        r.show(true);

    }


}