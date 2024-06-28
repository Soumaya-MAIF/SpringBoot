package fr.simplon.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.Product;

@Repository
public interface ProduitRepository extends CrudRepository<Product, Integer> {


}
