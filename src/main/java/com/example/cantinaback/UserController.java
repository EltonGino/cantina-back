//package com.example.cantinaback;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
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
//}

// UserController.java
package com.example.cantinaback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticatedUser = userService.loadUserByUsername(user.getUsername());
        if (authenticatedUser == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
    }
}