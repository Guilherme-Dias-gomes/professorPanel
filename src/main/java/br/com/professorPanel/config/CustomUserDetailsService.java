package br.com.professorPanel.config;

import br.com.professorPanel.models.Login;
import br.com.professorPanel.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = repository.findByEmail(email)
                .orElseThrow(() => new UserEmailNotFoundExcpetion("Usuario não encontrado " + email));
        return new CustomUserDetailsService(login);
    }
}
