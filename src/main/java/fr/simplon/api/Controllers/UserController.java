package fr.simplon.api.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import fr.simplon.api.models.Utilisateur;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.simplon.api.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    @PostMapping
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUser = new Utilisateur(utilisateur.getUsername());
        return utilisateurRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public Optional<Utilisateur> getOneUser(@PathVariable Integer userId) {
        return utilisateurRepository.findById(userId);
    }


}