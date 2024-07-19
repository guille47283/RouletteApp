package com.rouletteapp.roulette.repository;

import com.rouletteapp.roulette.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
