package com.rouletteapp.roulette.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @NotBlank
    @NotEmpty
    @Column
    private String username;

    @Email
    @Column( unique=true , nullable = false)
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
