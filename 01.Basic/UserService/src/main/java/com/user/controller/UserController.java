package com.user.controller;

import com.user.dto.UserDTO;
import com.user.exception.UserException;
import com.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        String randomUserIDd = UUID.randomUUID().toString();
        userDTO.setUserId(randomUserIDd);
        userService.saveUser(userDTO);
        String msg = "User created successfully " + userDTO.getUserId();
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAllUsers();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String userId) throws UserException {
        UserDTO userDTO = userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
