package com.example.login.Service;

import com.example.login.Dto.LoginDTO;
import com.example.login.Dto.UserDTO;
import com.example.login.Response.LoginResponse;
import org.springframework.stereotype.Service;

public interface UserService {

    LoginResponse loginUser(LoginDTO loginDTO);

    String addUser(UserDTO userDto);
}
