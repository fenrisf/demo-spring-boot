package com.example.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by albertomartinez on 9/03/17.
 */
@Entity
@Data
public class Book {
    private static final long serialVersionUID = 1L;
    @Id
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "author")
    String author;
    @Column(name = "price")
    double price;

}
