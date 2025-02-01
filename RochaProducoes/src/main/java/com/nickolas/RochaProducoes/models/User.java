package com.nickolas.RochaProducoes.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name", nullable = false)
    @NotBlank(message = "Campo em branco.")
    private String userName;

    @Column(name = "user_password", nullable = false)
    @NotBlank(message = "Campo em branco.")
    private String password;

    @Column(name = "user_email", unique = true, nullable = false)
    @NotBlank(message = "Campo em branco.")
    private String email;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
