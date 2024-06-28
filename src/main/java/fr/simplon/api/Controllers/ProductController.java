package fr.simplon.api.Controllers;

import fr.simplon.api.models.Product;
import fr.simplon.api.models.Utilisateur;
import fr.simplon.api.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return (List<Product>) produitRepository.findAll();
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return produitRepository.save(product);
    }
}
