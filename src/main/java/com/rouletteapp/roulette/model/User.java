package com.rouletteapp.roulette.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.StringBufferInputStream;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name="users")

public class User {
    @Id
    private Integer id;
    private String username;

    private String mail;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime lastLogin;
}
