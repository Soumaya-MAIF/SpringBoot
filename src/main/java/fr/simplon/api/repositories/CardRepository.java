package fr.simplon.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {


    CardRepository get(int user);
}