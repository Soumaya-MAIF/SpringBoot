package fr.simplon.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.Utilisateur;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    public Optional<Utilisateur> findByUsername(String username);

    public Optional<Utilisateur> findByUsernameAndPassword(String username, String password); // Springboot génére directement la requête sql d'après le nom de la fonction sans croncrètement créer la fonction (et le code associé) => RIEN A ECRIRE !
}