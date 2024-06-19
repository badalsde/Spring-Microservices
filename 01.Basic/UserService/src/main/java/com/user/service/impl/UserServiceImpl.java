package com.user.service.impl;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserException;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserDTO userDTO) {
        userRepository.save(UserDTO.toEntity(userDTO));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : userList) {
            userDTOs.add(UserDTO.toDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserDTO getUserById(String userId) throws UserException {
       Optional<User> optionalUser = userRepository.findById(Integer.valueOf(userId));
       User user = optionalUser.orElseThrow(()->new UserException("User not found"));
       return UserDTO.toDTO(user);
    }
}
