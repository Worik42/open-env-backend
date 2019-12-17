package ru.kemsu.openenv.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private String username;

    private boolean isAdmin;

    public RoleDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
