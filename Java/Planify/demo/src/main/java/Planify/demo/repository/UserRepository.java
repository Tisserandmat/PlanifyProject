package Planify.demo.repository;

import org.springframework.stereotype.Repository;

import Planify.demo.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM USER u")
	List<User> getAllWorkshops();
}
