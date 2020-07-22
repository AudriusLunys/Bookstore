package bookstore.main;


import bookstore.DAO.AuthorDao;
import bookstore.DAO.BookDao;
import bookstore.DAO.BookstoreDao;
import bookstore.domain.Author;
import bookstore.domain.Book;
import bookstore.domain.Bookstore;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // creating author
        Author author1 = new Author("Vacys", "Maslionka", LocalDate.of(1988, 05, 24), "England");
        Author author2 = new Author("Virgis", "Monka", LocalDate.of(1968, 02, 12), "Germany");
        Author author3 = new Author("Jonas", "Jonka", LocalDate.of(1956, 11, 25), "Mali");


        //adding authors to database
        AuthorDao authorDao = new AuthorDao();
        authorDao.addAuthor(author1);
        authorDao.addAuthor(author2);
        authorDao.addAuthor(author3);

        // creating book
        Book book1 = new Book("Zombiai", 23.0, author1);
        Book book2 = new Book("Betmanas", 53.0, author1);
        Book book3 = new Book("Vampyrai", 53.50, author1);
        Book book4 = new Book("Geguzio ziedai", 13.90, author2);
        Book book5 = new Book("Jusu sodai", 33.50, author2);
        Book book6 = new Book("Musu Girios", 11.30, author2);
        Book book7 = new Book("Avengers", 123.50, author3);
        Book book8 = new Book("Ratatuile", 11.77, author3);
        Book book9 = new Book("South", 41.50, author3);

        //adding books to database
        BookDao bookDao = new BookDao();
        bookDao.addBook(book1);
        bookDao.addBook(book2);
        bookDao.addBook(book3);
        bookDao.addBook(book4);
        bookDao.addBook(book5);
        bookDao.addBook(book6);
        bookDao.addBook(book7);
        bookDao.addBook(book8);
        bookDao.addBook(book9);

        Set<Book> store1Books = new HashSet<>();
        store1Books.add(book1);
        store1Books.add(book2);
        store1Books.add(book3);
        store1Books.add(book8);
        store1Books.add(book9);
        Set<Book> store2Books = new HashSet<>();
        store2Books.add(book4);
        store2Books.add(book5);
        store2Books.add(book6);
        store2Books.add(book7);
        store2Books.add(book1);
        store2Books.add(book2);

        // create Bookstore
        Bookstore bookstore1 = new Bookstore("Store of Books", "streetname 4", "bookstore@gmail.com", store1Books);
        Bookstore bookstore2 = new Bookstore("Other Books", "Avenue 4", "megastore@yahoo.com", store2Books);
        BookstoreDao bookstoreDao = new BookstoreDao();
        bookstoreDao.addBookStore(bookstore1);
        bookstoreDao.addBookStore(bookstore2);


        // update author
        author1.setCountry("Suvalkai");
        authorDao.updateAuthor(author1);
        // update book
        book2.setPrice(550.0);
        bookDao.updateBook(book2);
        // update bookstore
        bookstore1.setAddress("Gedimino pr 5, Vilnius");
        bookstoreDao.updateBookStore(bookstore1);

        //delete author also deletes his books
        //authorDao.removeAuthor(authorDao.getAuthor(1));

        // delete bookstore also deletes books
        // bookstoreDao.removeBookStore(bookstoreDao.getBookStore(1));

    }
}
