package com.company;


public class Main {
        public static void main(String args[]) {
            //створюю пустий об'єкт класу Бібліотека
            Library library = new Library();

            //додаю новвих Бібліотекарів
            library.setLibrarians( new Librarian("Alex", "Melnik", "Ivanov", 46, Sex.man, "+067-063-32-21", 456.2));
            library.setLibrarians( new Librarian("Olena", "Ivanova", "Petrivna", 40, Sex.woman, "+067-063-53-11", 456.2));

            //додаю Авторів, Книги яких зберігаються в Бібліотеці
            library.setAuthors(new Author("Taras", "Shevchenko","Hryhorovych", 47, Sex.man, 1840, 1861));
            library.setAuthors(new Author("Ivan", "Franko", "Yakovych", 60, Sex.man, 1874,1916));

            //додаю Книги, вказуючи їх назву і Автора. Також важливий параметр - тип доступу
            //Він буде використовуватися для ідентифікації доступності даної Книги
            //Окрім того, вказуємо кількість примірників
            library.setBooks(new Book("Kobzar", library.searchAuthorBySurname("Shevchenko"), 5, Type.all));
            library.setBooks(new Book("Perebendya", library.searchAuthorBySurname("Shevchenko"), 3, Type.teacher));
            library.setBooks(new Book("Fateful Crossroads",library.searchAuthorBySurname("Franko") , 1, Type.teacher));
            library.setBooks(new Book("Kamenyari",library.searchAuthorBySurname("Franko") , 2, Type.all));

            //додаю Читачів до Бібліотеки, обов'язково вказавши тип доступу
            library.setReaders(new Reader("Anna", "Sherepa", "Valeriivna", 19, Sex.woman, Type.all));

            //Симулююємо ситуацію запису книги.
            //Шукаємо відповідного читача по ІД(у кожного буде унікальний). Шкаємо об'єкт Книги серед списку по назві.
            //Також в Запис зберігаємо Бібліотераря, який здійсний запис.
            //При створенні Запису орієнтуємося на типи доступу
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Kobzar"), library.searchLibrarianById(0));
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Kamenyari"), library.searchLibrarianById(0));

            //На даному прикладі демонструю, що Запис буде відхилений, оскільки для отримання даного примірника необхідно мати тип доступу teacher
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Fateful Crossroads"), library.searchLibrarianById(0));//access will be denied

            //Викликаємо метод для перегляду детальної інформації про Читача і, відповідно, всі його Записи
            library.searchReaderById(0).show(true);

            //Демонструю можливість видалення Запису, орієнтуючись по його номеру в списку.(При виведенні - нумерація розпочинається з 1, проте у масиві - з 0)

            library.deleteRecord(library.searchReaderById(0), 0);
            library.searchReaderById(0).show(true);

            //Демонструю обмеження Запису, враховуючи кількість примірників в бібліотеці
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Kamenyari"), library.searchLibrarianById(0));
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Kamenyari"), library.searchLibrarianById(0));
            library.searchReaderById(0).show(true);

            //Можливість видалення запису може бути також здійснення по назві книги.
            library.deleteRecord(library.searchReaderById(0), library.searchBookByName("Kamenyari"));
            library.searchReaderById(0).show(true);


            //Оскільки Запис - це nested клас, то всі операції, пов'язані з ним, повині бути здійсненні через відповідного Читача
        }

}
