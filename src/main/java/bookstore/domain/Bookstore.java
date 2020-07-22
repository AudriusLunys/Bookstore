package bookstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Store")
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer bookStoreId;

    private String name;
    private String address;
    private String email;

    @ManyToMany
    @JoinTable (name= "join_books_bookstores", joinColumns = {@JoinColumn(name="bookStoreId")},
            inverseJoinColumns ={@JoinColumn(name = "bookId")} )
    private Set<Book> books=new HashSet<>();

    public Bookstore() {
    }

    public Bookstore(String name, String address, String email, Set<Book> books) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.books = books;
    }

    public Integer getBookStoreId() {
        return bookStoreId;
    }

    public void setBookStoreId(Integer bookStoreId) {
        this.bookStoreId = bookStoreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}

