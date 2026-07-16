package com.user_service.app.dto.user;

import com.user_service.app.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private int age;

   UserEntity toEntity(){
       return new UserEntity(this.name,this.email,this.age);
   }
}
