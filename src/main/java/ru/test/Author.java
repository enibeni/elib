package ru.test;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by enibeni on 25.11.15.
 */
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int author_id;

    @Column(name = "fname", nullable = true)
    private String fname;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private Set<Book> books = new HashSet<Book>();

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return author_id + ":" + fname;
    }
}
