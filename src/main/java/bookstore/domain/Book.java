package bookstore.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable (name = "Book_store", joinColumns = {@JoinColumn(name ="book_Id")},
            inverseJoinColumns = {@JoinColumn(name="Id")})
   private Set<Bookstore> bookstores = new HashSet<>();

    public Book() {
    }

    public Book(String title, Double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    public Set<Bookstore> getBookstores() {
        return bookstores;
    }

    public void setBookstores(Set<Bookstore> bookstores) {
        this.bookstores = bookstores;
    }
}

