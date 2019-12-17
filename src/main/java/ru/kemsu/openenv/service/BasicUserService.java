package ru.kemsu.openenv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kemsu.openenv.exception.model.UserAlreadyCreatedException;
import ru.kemsu.openenv.model.Authority;
import ru.kemsu.openenv.model.User;
import ru.kemsu.openenv.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class BasicUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public BasicUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(final User user) {
        User _user = repository.findByUsername(user.getUsername());
        if (_user != null) {
            throw new UserAlreadyCreatedException("Пользователь уже существует");
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
            return repository.save(user);
        }
    }

    @Override
    public User find(final String id) {
        return repository.findById(id).get();
    }

    @Override
    public User findByUsername(final String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User update(final String id, final User user) {
        user.setId(id);

        final User saved = repository.findById(id).get();

        if (saved != null) {
            user.setCreatedAt(saved.getCreatedAt());
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(user);
        return user;
    }

    @Override
    public String delete(final String id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public User changeRole(String name, boolean isAdmin) {
        final User user = repository.findByUsername(name);
        if (user != null) {
            List<Authority> authorities = new ArrayList<>();
            if (isAdmin)
                authorities.add(Authority.ROLE_ADMIN);
            else
                authorities.add(Authority.ROLE_USER);

            user.setAuthorities(authorities);
            repository.save(user);
            return user;
        } else {
            return null;
        }
    }
}
