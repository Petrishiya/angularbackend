package com.spring.angularbackend.service;
import com.spring.angularbackend.exception.DuplicateDataException;
import com.spring.angularbackend.pojo.User;
import com.spring.angularbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        try {

            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateDataException("Email or Mobile Number already exists!");
        }
    }


    public List<String> getAssigneesAndCreators() {
        return userRepository.findAll().stream()
                .filter(user -> user.getStatus() == User.Status.ACTIVE)
                .map(User::getName)
                .collect(Collectors.toList());
    }


    public User updateUserStatus(Long userId, User.Status status) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));
        user.setStatus(status);
        return userRepository.save(user);
    }
}
