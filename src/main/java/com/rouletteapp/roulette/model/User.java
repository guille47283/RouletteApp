package com.rouletteapp.roulette.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table( name = "users")

public class User {
    @JsonIgnore
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String username;


    @Column( unique=true , nullable = false)
    @Email (message = "Wrong Email ")
    private String email;


    @Column
    private String password;

    @JsonIgnore
    @Column (nullable = true)
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column (nullable = true)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column (nullable = true)
    private LocalDateTime lastLogin;

    @PrePersist
    protected void OnCreate (){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        lastLogin = null;
    }

}
