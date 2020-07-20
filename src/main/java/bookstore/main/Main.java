package bookstore.main;


import bookstore.DAO.AuthorDao;
import bookstore.DAO.BookDao;
import bookstore.DAO.BookstoreDao;
import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // creating author
        Author author1 = new Author("Vacys", "Maslionka", LocalDate.of(1988,05,24),"England");
        Author author2 = new Author("Virgis", "Manka", LocalDate.of(1968,02,12),"Doichland");
        //adding authors to database
        AuthorDao authorDao = new AuthorDao();
        authorDao.addAuthor(author1);
        authorDao.addAuthor(author2);
         // create Bookstore
        Bookstore bookstore1 = new Bookstore("Store of Books", "streetname 4","bookstore@gmail.com");
        Bookstore bookstore2 = new Bookstore("Other Books", "Avenue 4","megastore@yahoo.com");
        BookstoreDao bookstoreDao = new BookstoreDao();
        bookstoreDao.addBookStore(bookstore1);
        bookstoreDao.addBookStore(bookstore2);
        // creating book
        Book book1 = new Book("Zombiai",23.0,author1,bookstore2);
        Book book2 = new Book("Betmanas",53.0,author1,bookstore1);
        Book book3 = new Book("Vampyrai",53.50,author1,bookstore1);
        Book book4 = new Book("Geguzio ziedai",13.90,author2,bookstore1);
        Book book5 = new Book("Musu sodai",33.50,author2,bookstore2);

        //adding authors to database
        BookDao bookDao = new BookDao();
        bookDao.addBook(book1);
        bookDao.addBook(book2);
        bookDao.addBook(book3);
        bookDao.addBook(book4);
        bookDao.addBook(book5);

        author1.setCountry("Suvalkai");
        authorDao.updateAuthor(author1);

        book2.setPrice(550.0);
        bookDao.updateBook(book2);

        //authorDao.removeAuthor(authorDao.getAuthor(1));



    }
}
