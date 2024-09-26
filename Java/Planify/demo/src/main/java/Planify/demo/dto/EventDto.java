package Planify.demo.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EventDto {
	@NotNull
    @Size(min = 3, max = 30)
	private String title;
	@NotNull
    @Size(min = 3, max = 30)
	private String description;

	// Début et fin de l'événement avec date et heure
	@NotNull
	private LocalDateTime eventDateStart;
	@NotNull
	private LocalDateTime eventDateEnd;

	@NotNull
	private String address;
	@NotNull
	private int zipCode;
	@NotNull
	private String city;

	// Nombre de participants minimum (utilisation de Integer pour permettre des
	// valeurs nulles)
	private Integer numberOfParticipantsMin;
	// Nombre de participants maximum (utilisation de Integer pour permettre des
	// valeurs nulles)
	@NotNull
	private Integer numberOfParticipantsMax;
}
