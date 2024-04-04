package com.rouletteapp.roulette.service;

import com.rouletteapp.roulette.model.User;
import com.rouletteapp.roulette.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final IUserRepository userRepository;
    public User savedUser (User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);

        log.info("Employee with id: {} saved successfully", user.getId());
        return savedUser;
    }

}
