package ru.kemsu.openenv.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private String username;

    private int isAdmin;

    public RoleDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
