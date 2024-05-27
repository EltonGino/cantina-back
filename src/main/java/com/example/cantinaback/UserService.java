//package com.example.cantinaback;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//    public interface UserRepository extends MongoRepository<User, String> {
//        Optional<User> findByUsername(String username);
//    }
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        User registeredUser = userService.register(user);
//        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//        User authenticatedUser = userService.loadUserByUsername(user.getUsername());
//        return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
//    }
//
//}

// UserService.java
package com.example.cantinaback;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}