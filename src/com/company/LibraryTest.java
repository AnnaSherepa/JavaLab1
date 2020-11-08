package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {



    @Test
    public void searchBookByName() {
        Library library = new Library();
        Author author1 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        library.setAuthors(author1);

        Book book1 = new Book("Перебендя", library.searchAuthorBySurname("Шевченко"), 3, Type.teacher);
        library.setBooks(book1);
        Book actual = library.searchBookByName("Перебендя");

        Assert.assertEquals(book1, actual);

    }
    @Test
    public void searchBookByName_NULL() {
        Library library = new Library();
        Book actual = library.searchBookByName("Перебендя");
        Assert.assertNull(actual);

    }

    @Test
    public void searchAuthorBySurname() {
        Library library = new Library();
        Author author3 = new Author("Леся", "Українка","Петрівна", 47, Sex.woman, 1840, 1861);
        library.setAuthors(author3);
        Author actual = library.searchAuthorBySurname("Українка");
        Assert.assertEquals(actual, author3);
    }


    @Test
    public void searchAuthorBySurname_NULL() {
        Library library = new Library();
        Author actual = library.searchAuthorBySurname("Українка");
        Assert.assertNull(actual);
    }

    @Test
    public void searchLibrarianById() {
        Library library = new Library();
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        library.setLibrarians(librarian);
        Librarian actual = library.searchLibrarianById(0);
        Assert.assertEquals(librarian, actual);
    }
    @Test
    public void searchLibrarianById_NULL() {
        Library library = new Library();
        Librarian actual = library.searchLibrarianById(1);
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderByName() {
        Library library = new Library();
        Reader reader = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        library.setReaders(reader);

        Reader actual = library.searchReaderByName("Анна");
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderByName_NULL() {
        Library library = new Library();
        Reader actual = library.searchReaderByName("Анна");
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderById() {
        Library library = new Library();
        Reader reader = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        library.setReaders(reader);
        Reader actual = library.searchReaderById(0);
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderById_NULL() {
        Library library = new Library();
        Reader actual = library.searchReaderById(0);
        Assert.assertNull(actual);
    }

    @Test
    public void showListOfBooks() {
        Library library = new Library();
        Author author1 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        library.setAuthors(author1);

        Book book1 = new Book("Перебендя", library.searchAuthorBySurname("Шевченко"), 3, Type.teacher);
        Book book2 = new Book("Кобзар", library.searchAuthorBySurname("Шевченко"), 1, Type.teacher);

        library.setBooks(book1);
        library.setBooks(book2);

        library.showListOfBooks();
    }

    @Test
    public void showListOfBooks_NULL() {
        Library library = new Library();
        library.showListOfBooks();
    }

    @Test
    public void showListOfAuthors() {
        Library library = new Library();
        library.setAuthors(new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861));
        library.setAuthors(new Author("Іван", "Франко", "Якович", 60, Sex.man, 1874,1916));
        library.showListOfAuthors();
    }


    @Test
    public void showListOfAuthors_NULL() {
        Library library = new Library();
        library.showListOfAuthors();
    }

    @Test
    public void showListOfReaders() {
        Library library = new Library();
        Reader reader = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        library.setReaders(reader);
        library.showListOfReaders();
    }


    @Test
    public void showListOfReaders_NULL() {
        Library library = new Library();
        library.showListOfReaders();
    }


    @Test
    public void showListOfLibrarian() {
        Library library = new Library();
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        library.setLibrarians(librarian);
        library.showListOfLibrarian();
    }


    @Test
    public void showListOfLibrarian_NULL() {
        Library library = new Library();
        library.showListOfLibrarian();
    }

    @Test
    public void setRecord() {
        Library library = new Library();
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        library.setLibrarians(librarian);
        library.setAuthors(new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861));
        Book book1 = new Book("Кобзар", library.searchAuthorBySurname("Шевченко"), 3, Type.all);
        library.setBooks(book1);
        library.setReaders(new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all));
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));

    }

    @Test
    public void deleteRecord() {
        Library library = new Library();
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        library.setLibrarians(librarian);
        library.setAuthors(new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861));
        Book book1 = new Book("Кобзар", library.searchAuthorBySurname("Шевченко"), 3, Type.all);
        library.setBooks(book1);
        library.setReaders(new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all));
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
        Reader r = library.getReaders().get(0);
        r.show(true);

        library.deleteRecord(library.searchReaderById(0), 0);

        r.show(true);

    }


}