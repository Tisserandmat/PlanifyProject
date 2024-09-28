package Planify.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Génère automatiquement les getters, setters, toString, equals et hashCode
@NoArgsConstructor // Génère un constructeur sans argument
public class UserDto {
	
	@NotNull
    @Size(min = 3, max = 30)
	private String lastname; // Nom de famille
	@NotNull
    @Size(min = 3, max = 30)
    private String firstname; // Prénom
	
	@Size(min = 4, max = 25)
	@NotNull
	private String pseudo;
	@NotNull
	@Size(min = 6, max = 30)
    private String password;


	@NotNull
	@Email
    private String email;
	
    @Pattern(regexp = "^[0-9\\-\\+\\s\\(\\)]{10,15}$", message = "Numéro de téléphone invalide")
    private String phoneNumber;
    
    private String address;
    private int zipCode;
    private String city;
    private String sexe;
    private String dateOfBirth;
}
