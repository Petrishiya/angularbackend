package com.spring.angularbackend.controller;

import com.spring.angularbackend.exception.DuplicateDataException;
import com.spring.angularbackend.pojo.User;
import com.spring.angularbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.angularbackend.repository.UserRepository;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
/*
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (DuplicateDataException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
*/

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // The status is already set to ACTIVE in the User entity constructor
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }


   /* @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User savedUser = userRepository.save(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(409).build();
        }
    }*/

  /*@PutMapping("/updateStatus/{id}")
    public ResponseEntity<User> updateStatus(@PathVariable Long id, @RequestBody User.Status status) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User user = userData.get();
            user.setStatus(status);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/getAssigneesAndCreators")
    public List<String> getAssigneesAndCreators() {
        return userService.getAssigneesAndCreators();
    }

    //For status change
    @PutMapping("/updateStatus/{userId}")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long userId, @RequestBody Map<String, User.Status> request) {
        String status = request.get("status").toString();
        User updatedUser = userService.updateUserStatus(userId, User.Status.valueOf(status));
        return ResponseEntity.ok(updatedUser);
    }

    //For name update

    @PutMapping("/updateUsername/{id}")
    public ResponseEntity<User> updateUsername(@PathVariable Long id, @RequestBody User updatedUser) {
       System.out.println(userRepository.findById(id));
        System.out.println("Received ID: " + id);  // Debugging log
        System.out.println("Updated User: " + updatedUser);

        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName()); // Only updating the name
                    User savedUser = userRepository.save(user);
                    return ResponseEntity.ok(savedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}