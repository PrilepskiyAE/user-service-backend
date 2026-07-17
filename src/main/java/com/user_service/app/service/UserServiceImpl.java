package com.user_service.app.service;

import com.user_service.app.dto.user.UserRequest;
import com.user_service.app.dto.user.UserResponse;
import com.user_service.app.entity.UserEntity;
import com.user_service.app.exception.UserAlreadyExistsException;
import com.user_service.app.exception.UserNotFoundException;
import com.user_service.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest user) {

        UserEntity entity = user.toEntity();

        UserEntity savedEntity = userRepository.save(entity);

        return savedEntity.toResponse();
    }

    @Override
    public UserResponse getUserById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
       return entity.toResponse();
    }

    @Override
    public List<UserResponse> getAllUsers() {
      return   userRepository.findAll()
                .stream()
                .map(UserResponse::fromEntity)
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        String newEmail = request.getEmail().trim();

        if (!entity.getEmail().equals(newEmail) && userRepository.existsByEmail(newEmail)) {
            throw new UserAlreadyExistsException(newEmail);
        }

        entity.setName(request.getName().trim());
        entity.setEmail(newEmail);
        entity.setAge(request.getAge());

        UserEntity updatedEntity = userRepository.save(entity);

        return updatedEntity.toResponse();
    }

    @Override
    public void deleteUserById(Long id) {
        UserEntity entity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(entity);
    }

    @Override
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

}
