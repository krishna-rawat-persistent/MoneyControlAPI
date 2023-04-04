package com.psl.MoneyControlAPI.service;

import com.psl.MoneyControlAPI.entity.User;
import com.psl.MoneyControlAPI.model.Login;
import com.psl.MoneyControlAPI.model.Register;
import com.psl.MoneyControlAPI.repository.LoginRepo;
import com.psl.MoneyControlAPI.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response login(Login login) {
        User user = repo.findByEmail(login.getEmail());
        if(user!=null){
            String plaintextPassword = login.getPassword();
            String encryptedPassword = user.getPassword();

            Boolean passwordMatched = passwordEncoder.matches(plaintextPassword,encryptedPassword);
            if(passwordMatched){
                Optional<User> validUser = repo.findOneByEmailAndPassword(login.getEmail(),encryptedPassword);
                if(validUser.isPresent()){
                    return Response.builder().status(true).message("Login Successful !!").email(login.getEmail()).build();
                }else{
                    return Response.builder().status(true).message("Invalid Credentials !!").build();
                }
            }else {
                return Response.builder().status(false).message("Credentials not Matching!!").build();
            }
        }
        return Response.builder().status(false).message("Email Not Exist !!").build();
    }

    @Override
    public Response register(Register register) {
        if(register.getName().equals("") || register.getEmail().equals("") || register.getPassword().equals("")){
            return Response.builder().message("Please fill all the values").status(false).build();
        }
        try {
            repo.save(User.builder().email(register.getEmail()).name(register.getName()).password(passwordEncoder.encode(register.getPassword())).build());
        }catch (Exception e){
            return Response.builder().message("Some exception occurred").status(false).build();
        }
        return Response.builder().email(register.getEmail()).message("User Registered Successfully !!").status(true).build();
    }
}
