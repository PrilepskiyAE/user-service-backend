package com.user_service.app.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
        super("Пользователь с таким email уже существует: " + email);
    }
}
