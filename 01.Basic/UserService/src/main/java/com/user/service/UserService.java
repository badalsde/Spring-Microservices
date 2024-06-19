package com.user.service;

import com.user.dto.UserDTO;
import com.user.entity.User;
import com.user.exception.UserException;

import java.util.List;

public interface UserService {
    public void saveUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(String userId) throws UserException;
}
