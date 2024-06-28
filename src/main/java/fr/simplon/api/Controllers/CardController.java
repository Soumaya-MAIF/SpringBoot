package fr.simplon.api.Controllers;

import fr.simplon.api.MessageDTO.CardDTO;
import fr.simplon.api.models.Card;
import fr.simplon.api.models.Product;
import fr.simplon.api.models.Utilisateur;
import fr.simplon.api.repositories.CardRepository;
import fr.simplon.api.repositories.ProduitRepository;
import fr.simplon.api.repositories.UtilisateurRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    //private final CardRepository cardRepository;
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    //private final CardRepository cardRepository;
    private CardRepository cardRepository;


    @PostMapping
    public Card createCard(@RequestBody CardDTO card) { // DTO  -> récupération des infos du user et du produit à partir de leurs id via MessageCreateCard
        Card newCard = new Card();
        Utilisateur user = utilisateurRepository.findById(card.getUser()).get();
        newCard.setUtilisateur(user);
        Product product = produitRepository.findById(card.getProduit()).get();
        List<Product> listProduits = new ArrayList<>();
        listProduits.add(product);
        newCard.setProduct(listProduits);
        newCard.setCreationDate(LocalDateTime.now());
        return cardRepository.save(newCard);
    }

    @GetMapping("/{cardId}")
    public Optional<Card> getOneUser(@PathVariable Integer cardId) {
        return cardRepository.findById(cardId);
    }

    @GetMapping
    public List<Card> getAllCards() {

        return (List<Card>) cardRepository.findAll();
    }



    // Exemple d'un point de terminaison pour ajouter un produit au panier existant
    @PutMapping("/{userId}")
    public void addProductToCard(@PathVariable int userId, @RequestBody CardDTO newProduct) {
        List<CardDTO> userCard = (List<CardDTO>) cardRepository.get(newProduct.getUser()).get();
        if (userCard != null) {
            userCard.add(newProduct);
        }
    }

    // Exemple d'un point de terminaison pour récupérer le panier d'un utilisateur
    @GetMapping("/{userId}")
    public List<CardDTO> getUserCard(@PathVariable int userId) {
        return cardRepository.getOrDefault(userId, new ArrayList<>());
    }
}