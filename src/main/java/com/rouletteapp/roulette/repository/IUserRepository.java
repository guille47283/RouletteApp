package com.rouletteapp.roulette.repository;

import com.rouletteapp.roulette.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
