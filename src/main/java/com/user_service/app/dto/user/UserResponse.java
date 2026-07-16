package com.user_service.app.dto.user;

import com.user_service.app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime createdAt;

    UserEntity toEntity(){
        return new UserEntity(this.id,this.name,this.email,this.age,this.createdAt);
    }
}
