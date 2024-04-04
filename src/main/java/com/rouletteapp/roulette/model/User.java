package com.rouletteapp.roulette.model;

import jakarta.persistence.*;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.io.StringBufferInputStream;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table( name = "users")

public class User {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;
    @Column
    private LocalDateTime lastLogin;
}
