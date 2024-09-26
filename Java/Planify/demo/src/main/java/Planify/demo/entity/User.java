package Planify.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastname; // Nom de famille
    private String firstname; // Prénom

    @Email(message = "Adresse e-mail invalide")
    private String email;

    @Pattern(regexp = "^[0-9\\-\\+\\s\\(\\)]{10,15}$", message = "Numéro de téléphone invalide")
    private String phoneNumber;

    private String address;
    private int zipCode;
    private String city;
    private String sexe;
    private String dateOfBirth;

    // Relation avec les événements créés par cet utilisateur
    @OneToMany(mappedBy = "creator") // Un utilisateur peut créer plusieurs événements
    private List<Event> createdEvents;

    // Relation avec les événements auxquels cet utilisateur participe
    @ManyToMany
    @JoinTable(
        name = "user_event", // Table de jointure pour les participations
        joinColumns = @JoinColumn(name = "user_id"), // Référence à l'utilisateur
        inverseJoinColumns = @JoinColumn(name = "event_id") // Référence à l'événement
    )
    private List<Event> participatedEvents; // Liste des événements auxquels l'utilisateur participe
}