package com.psl.MoneyControlAPI.controller;

import com.psl.MoneyControlAPI.model.Login;
import com.psl.MoneyControlAPI.model.Register;
import com.psl.MoneyControlAPI.response.Response;
import com.psl.MoneyControlAPI.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("")
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService service;


    @PostMapping("/register")
    public Response register(@RequestBody Register register){
        return service.register(register);
    }

    @PostMapping("/login")
    public Response login(@RequestBody Login login){
        return service.login(login);
    }

}
