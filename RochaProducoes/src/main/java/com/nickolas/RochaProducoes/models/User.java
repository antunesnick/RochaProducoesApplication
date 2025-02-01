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








}
