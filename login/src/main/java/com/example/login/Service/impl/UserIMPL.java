package com.example.login.Service.impl;
import com.example.login.Dto.LoginDTO;
import com.example.login.Dto.UserDTO;
import com.example.login.Entity.User;
import com.example.login.Repo.UserRepo;
import com.example.login.Response.LoginResponse;
import com.example.login.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDto) {

        User user =  new User(

                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword())
        );

        userRepo.save(user);
        return user.getName();
    }

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg="";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if(user1 != null) {
            String password = loginDTO.getPassword();
            String encodePassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if(isPwdRight){
                Optional<User> user =userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
                if(user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed:",false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email Not Exist", false);
        }
    }
}
