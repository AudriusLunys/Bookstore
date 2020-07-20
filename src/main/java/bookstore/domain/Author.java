package bookstore.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "Authors")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "author_id")
    private Integer authorId;

    @Column (name = "first_name")
    private String firstName;
    @Column (name="last_name")
    private String lastName;
    @Column (name="date_of_birth")
    private LocalDate dateOfBirth;
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)

    private Set<Book> books=new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName, LocalDate dateOfBirth, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }
}
