package com.user_service.app.controller;

import com.user_service.app.dto.user.UserRequest;
import com.user_service.app.dto.user.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
public interface UserController {

   @PostMapping
   ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request);

   @GetMapping("/{id}")
   ResponseEntity<UserResponse> getUserById(@PathVariable Long id);

   @GetMapping
   ResponseEntity<List<UserResponse>> getAllUsers();

   @PutMapping("/{id}")
   ResponseEntity<UserResponse> updateUser(
           @PathVariable Long id,
           @RequestBody UserRequest request
   );

   @DeleteMapping("/{id}")
   ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
