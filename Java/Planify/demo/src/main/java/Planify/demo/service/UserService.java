package Planify.demo.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Planify.demo.dto.UserDto;
import Planify.demo.entity.User;
import Planify.demo.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserService {


	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private final ModelMapper modelMapper;
	private final BCryptPasswordEncoder passwordEncoder;
	private final UserRepository userRepo;

	// Injections des dépendances via constructeur
	@Autowired
	public UserService(ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder, UserRepository userRepo) {
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
		this.userRepo = userRepo;
	}

	/**
	 * Crée un utilisateur à partir d'un UserDto. Valide les données et transforme
	 * le DTO en entité User.
	 * 
	 * @param userDto L'objet DTO contenant les données de l'utilisateur à créer.
	 * @return Le UserDto avec les informations de l'utilisateur créé.
	 */
	public UserDto createUser(@Valid @RequestBody UserDto userDto) {
		// Hachage du mot de passe
		userDto.setPassword(hashPassword(userDto.getPassword()));

		// Mapper UserDto vers User
		User user = modelMapper.map(userDto, User.class);

		// Log avant la sauvegarde
		log.info("Création d'un nouvel utilisateur : {} en cours ..", user.getEmail());
		// Sauvegarde de l'utilisateur en base de données
		userRepo.save(user);

		// Retourner le DTO pour confirmation ou log
		log.info("Utilisateur créé avec succès : {}", user.getEmail());
		return userDto;
	}

	/**
	 * Hache password.
	 * 
	 * @param rawPassword Le mot de passe non haché
	 * @return Le mot de passe haché
	 */
	private String hashPassword(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}
}
