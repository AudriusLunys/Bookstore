package bookstore.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id")
    private Integer bookId;

    private String title;
    private Double price;
    @ManyToOne
    @JoinColumn (name = "authorId")
    private Author author;
    @ManyToOne
    @JoinColumn (name = "storeId")
    private Bookstore bookstore;
    public Book() {
    }

    public Book(String title, Double price, Author author ,Bookstore bookstore) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.bookstore=bookstore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                ", bookstore=" + bookstore +
                '}';
    }
}

