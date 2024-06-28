package fr.simplon.api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime creationDate ;

    private float price;

    @OneToMany
    private List<Product> product;

    @OneToOne
    private Utilisateur utilisateur;
    public Card() {

    }

}