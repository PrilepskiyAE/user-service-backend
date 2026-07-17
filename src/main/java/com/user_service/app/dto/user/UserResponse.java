package com.user_service.app.dto.user;

import com.user_service.app.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime createdAt;

    public UserEntity toEntity(){
        return new UserEntity(this.id,this.name,this.email,this.age,this.createdAt);
    }

    public static UserResponse fromEntity(UserEntity userEntity) {
        return new UserResponse(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getAge(),
                userEntity.getCreatedAt()
        );
    }
}
