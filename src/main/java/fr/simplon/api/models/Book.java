package fr.simplon.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    private String name;

    public Book(){}
}