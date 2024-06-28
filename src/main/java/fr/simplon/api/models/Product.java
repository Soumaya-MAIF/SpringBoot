package fr.simplon.api.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private float price;

    @ManyToOne
    private Card card;

    public Product(){


    }



}