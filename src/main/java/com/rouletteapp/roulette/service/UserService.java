package com.rouletteapp.roulette.service;

import com.rouletteapp.roulette.model.User;
import com.rouletteapp.roulette.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final IUserRepository userRepository;
    public User savedUser (User user){

        String hashPass = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        if (user.getId() != null) {
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            user.setLastLogin(LocalDateTime.now());
            user.setPassword(hashPass);
            User savedUser = userRepository.save(user);


            log.info("Employee with id: {} saved successfully", user.getId());
            return savedUser;
        }
        return null;
    }

    public Page<User> getAllUsers (Integer page, Integer size, Boolean enablePagination ) {
        return userRepository.findAll(enablePagination ? PageRequest.of(page,size): Pageable.unpaged() );
    }

    public List<User> getAllUsers2 (){
        return userRepository.findAll();
    }


    public void deleteUser (Integer id) {
        userRepository.deleteById(id);
    }

    public User editUser (User user){
        if (user.getId() != null && userRepository.existsById(user.getId())){
            return userRepository.save(user);

        }
      return null;
    }
    public boolean existById(Integer id) {
        return  userRepository.existsById(id);
    }


}
