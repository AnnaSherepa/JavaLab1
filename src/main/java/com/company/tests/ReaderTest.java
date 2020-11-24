package main.java.com.company.tests;

import main.java.com.company.lab1.*;
import org.junit.Test;

public class ReaderTest {

    @Test
    public void setRecord_Set_One_Record() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 3, Type.all);
        r.setRecord(book1, librarian);

    }

    @Test
    public void setRecord_Set_More_That_One() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 1, Type.all);

        r.setRecord(book1, librarian);
        r.setRecord(book1, librarian);

    }


    @Test
    public void setRecord_Check_An_Access() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 1, Type.teacher);
        r.setRecord(book1, librarian);

    }

    @Test
    public void deleteRecord_From_Reader_List_Of_Record() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        Librarian librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);

        Author a = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        Book book1 = new Book("Кобзар", a, 3, Type.all);

        r.setRecord(book1, librarian);
        r.deleteRecord(0);
    }

    @Test
    public void deleteRecord_Not_Existed_Record_null() {
        Reader r = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        r.deleteRecord(0);
    }

    @Test
    public void searchRecordId_Return_Id() {
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