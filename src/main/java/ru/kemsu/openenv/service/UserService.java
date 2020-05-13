package ru.kemsu.openenv.service;

import ru.kemsu.openenv.model.User;

import java.util.List;


public interface UserService {

    User create(User object);

    User find(String id);

    User findByUsername(String userName);

    List<User> findAll();

    User update(String id, User object);

    String delete(String id);

    User changeRole(String name, boolean isAdmin);

    boolean changePassword(String username, String newPassword);
}
