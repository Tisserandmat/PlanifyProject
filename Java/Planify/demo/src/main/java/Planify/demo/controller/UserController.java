package Planify.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Planify.demo.dto.UserDto;
import Planify.demo.entity.User;
import Planify.demo.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-Planify/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/new")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
       //VERIFICATION et sécurité l'ors de de la création de compte a faire:
		
	

        try {
            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>( null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
