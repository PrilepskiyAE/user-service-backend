package com.user_service.app.dto.user;

import com.user_service.app.entity.UserEntity;
import com.user_service.app.util.ValidEmail;
import com.user_service.app.util.ValidName;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequest {

    @ValidName
    private String name;

    @ValidEmail
    private String email;

    @NotNull(message = "Возраст обязателен")
    @Min(value = 0, message = "Возраст не может быть отрицательным")
    @Max(value = 100, message = "Возраст не может быть больше 100")
    @NotBlank
    private int age;


   public UserEntity toEntity(){
       return new UserEntity(this.name,this.email,this.age);
   }
}
