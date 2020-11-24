package main.java.com.company.tests;

import main.java.com.company.lab1.*;
import org.junit.Test;

public class ReaderTest {

    @Test
    public void setRecordOneRecord() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 3, Type.all);
        r.setRecord(book1, librarian);

    }

    @Test
    public void setRecordTwoRecords() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 1, Type.all);

        r.setRecord(book1, librarian);
        r.setRecord(book1, librarian);

    }


    @Test
    public void setRecordCheckAccess() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 1, Type.teacher);
        r.setRecord(book1, librarian);

    }

    @Test
    public void deleteRecordTestDeleting() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 3, Type.all);

        r.setRecord(book1, librarian);
        r.deleteRecord(0);
    }

    @Test
    public void deleteRecordTryToDeleteNotExistRecord() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        r.deleteRecord(0);
    }

    @Test
    public void searchRecordIdFindReader() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 3, Type.all);

        r.setRecord(book1, librarian);
        int i = r.searchRecordId(book1);
        r.show(true);
        System.out.println("ID: " + i);

    }
}