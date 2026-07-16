package com.user_service.app.service;

import com.user_service.app.dto.user.UserRequest;
import com.user_service.app.dto.user.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse createUser(UserRequest user);
    Optional<UserResponse> getUserById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id, String name, String email, int age);
    boolean deleteUserById(Long id);
    boolean isEmailExists(String email);
}
