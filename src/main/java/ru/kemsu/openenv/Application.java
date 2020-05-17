package ru.kemsu.openenv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kemsu.openenv.model.Authority;
import ru.kemsu.openenv.model.User;
import ru.kemsu.openenv.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.userRepository.findByUsername("891234566647") == null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(Authority.ROLE_ADMIN);
            authorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
            User user = new User();
            //authorities, "Nikolay", "Vorobev", "", "20021998", passwordEncoder.encode("worik"), "worik", false, false,
            user.setAuthorities(authorities);
            user.setFirstName("Nikolay");
            user.setPassword(passwordEncoder.encode("worik"));
            user.setDateOfBirth("20.02.1998");
            user.setUsername("891234566647");
            user.setLastName("vorobev");
            user.setPatronymic("das");
            user.setAccountNonExpired(false);
            user.setCredentialsNonExpired(false);
            user.setEnabled(true);
            this.userRepository.save(user);
        }
    }
}