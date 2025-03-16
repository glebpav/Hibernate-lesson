package org.example.full;



import org.example.full.dao.BookDao;
import org.example.full.model.Book;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDao bookDAO = new BookDao();

        Book book1 = new Book();
        book1.setTitle("1984");
        book1.setAuthor("George Orwell");
        book1.setYear(1949);

        Book book2 = new Book();
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setYear(1960);

        bookDAO.saveBook(book1);
        bookDAO.saveBook(book2);

        List<Book> books = bookDAO.getAllBooks();
        books.forEach(System.out::println);

        List<Book> orwellBooks = bookDAO.getBooksByAuthor("George Orwell");
        orwellBooks.forEach(System.out::println);

        List<Book> modernBooks = bookDAO.getBooksPublishedAfter(1950);
        modernBooks.forEach(System.out::println);

        Book bookToUpdate = bookDAO.getBookById(1L);
        bookToUpdate.setTitle("Nineteen Eighty-Four");
        bookDAO.updateBook(bookToUpdate);

        bookDAO.deleteBook(2L);
    }
}
