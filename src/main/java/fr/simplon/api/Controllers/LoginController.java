package fr.simplon.api.Controllers;

import java.util.InputMismatchException;
import java.util.Optional;

import fr.simplon.api.Exceptions.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.models.Utilisateur;
import fr.simplon.api.repositories.UtilisateurRepository;

@RestController
public class LoginController {


    private UtilisateurRepository userRepository;
    public LoginController(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/login")
    public Utilisateur createUser(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password
    )throws InvalidCredentialException {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                () -> new InvalidCredentialException("Check your credentials")

      );
    }

    @PostMapping("/register")
    public Utilisateur createUser(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password,
            @ModelAttribute("passwordConfirm") String passwordConfirm,
            @ModelAttribute("email") String email
    ) {
        if (password.equals(passwordConfirm)) {
            Utilisateur user = new Utilisateur(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } else {
            throw new InputMismatchException("Passwords didn't match");
        }
    }

}