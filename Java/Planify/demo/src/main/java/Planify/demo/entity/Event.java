package Planify.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String description;

	// Début et fin de l'événement avec date et heure
	private LocalDateTime eventDateStart;
	private LocalDateTime eventDateEnd;

	private String address;
	private int zipCode;
	private String city;

	// Nombre de participants minimum (utilisation de Integer pour permettre des
	// valeurs nulles)
	private Integer numberOfParticipantsMin;
	// Nombre de participants maximum (utilisation de Integer pour permettre des
	// valeurs nulles)
	private Integer numberOfParticipantsMax;
	// Relation avec le créateur de cet événement
	@ManyToOne
	@JoinColumn(name = "creator_id") // Référence à l'utilisateur créateur
	private User creator;

	// Relation avec les participants à cet événement
	@ManyToMany(mappedBy = "participatedEvents") // Un événement peut avoir plusieurs participants
	private List<User> participants; // Liste des utilisateurs qui participent à cet événement
}