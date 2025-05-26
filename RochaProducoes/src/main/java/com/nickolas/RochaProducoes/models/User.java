package com.nickolas.RochaProducoes.models;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("userName")
    private String userName;

    @Column(name = "user_password", nullable = false)
    @NotBlank(message = "Campo em branco.")
    @JsonProperty("userPassword")
    private String userPassword;

    @Column(name = "user_email", unique = true, nullable = false)
    @NotBlank(message = "Campo em branco.")
    @JsonProperty("userEmail")
    private String userEmail;

    public UUID getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}
