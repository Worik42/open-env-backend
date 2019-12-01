package ru.kemsu.openenv.security.service;


public interface TokenService {

    String getToken(String username, String password);
}
