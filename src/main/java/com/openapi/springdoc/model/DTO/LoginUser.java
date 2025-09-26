package com.openapi.springdoc.model.DTO;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginUser {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "loginUser [username=" + username + ", password=" + password + "]";
    }
}
