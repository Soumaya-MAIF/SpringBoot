package fr.simplon.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime creationDate;

    private float price;

    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany
    List<ProductRow> produits;

    public Order() {
    }
}