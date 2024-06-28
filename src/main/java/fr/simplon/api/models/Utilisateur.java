package fr.simplon.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @Column(nullable = false, unique = true)
   @NonNull
   private String username;
   private String email;
   private String name;

   @JsonIgnore
   private String password;

   @OneToOne
   private Card card;

   @OneToMany
   private List<Order> order;

   public Utilisateur(){
      
   }


}
