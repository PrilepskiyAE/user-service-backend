package com.user_service.app;

import com.user_service.app.dto.user.UserRequest;
import com.user_service.app.dto.user.UserResponse;
import com.user_service.app.entity.UserEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public abstract class BaseTest {
    protected  final Long USER_ID = 1L;
    protected  final Long SECOND_USER_ID = 2L;
    protected  final Long NOT_FOUND_USER_ID = 999L;

    protected  final String USER_NAME = "Alex";
    protected  final String UPDATED_USER_NAME = "Alex Updated";
    protected  final String OLD_USER_NAME = "Old Name";
    protected  final String SECOND_USER_NAME = "Bob";

    protected final String USER_EMAIL = "alex@mail.com";
    protected final String OLD_EMAIL = "old@mail.com";
    protected final String NEW_EMAIL = "new@mail.com";
    protected final String BUSY_EMAIL = "busy@mail.com";
    protected final String FREE_EMAIL = "free@mail.com";
    protected final String SECOND_USER_EMAIL = "bob@mail.com";

    protected final int USER_AGE = 25;
    protected final int OLD_AGE = 20;
    protected final int SECOND_USER_AGE = 30;


    protected UserEntity createUserEntity(
            Long id,
            String name,
            String email,
            int age
    ) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);
        userEntity.setEmail(email);
        userEntity.setAge(age);
        return userEntity;
    }

    protected UserRequest createUserRequest(
            String name,
            String email,
            int age
    ) {
        return new UserRequest(name, email, age);
    }

    protected void assertUserResponse(
            UserResponse actual,
            Long expectedId,
            String expectedName,
            String expectedEmail,
            int expectedAge
    ) {
        assertEquals(expectedId, actual.getId());
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedEmail, actual.getEmail());
        assertEquals(expectedAge, actual.getAge());
    }
}
