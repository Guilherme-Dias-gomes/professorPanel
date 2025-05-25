package br.com.professorPanel.repositories;

import br.com.professorPanel.models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, String> {
    Optional<Login> findByEmail(String email);
}
