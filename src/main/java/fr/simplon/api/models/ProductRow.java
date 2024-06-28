package fr.simplon.api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productRow")
public class ProductRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Product product;

    private int quantity;

    private float price;

    private float discount;


    public ProductRow() {
    }
}