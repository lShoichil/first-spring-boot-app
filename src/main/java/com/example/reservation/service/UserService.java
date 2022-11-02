package com.example.reservation.service;

import com.example.reservation.entity.UserEntity;
import com.example.reservation.exception.UserAlreadyExistException;
import com.example.reservation.exception.UserNotFoundException;
import com.example.reservation.model.User;
import com.example.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername())  != null) {
            throw new UserAlreadyExistException("Пользователь уже есть");
        }
        return userRepository.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

}
