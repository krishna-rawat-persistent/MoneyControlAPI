package com.psl.MoneyControlAPI.service;

import com.psl.MoneyControlAPI.model.Login;
import com.psl.MoneyControlAPI.model.Register;
import com.psl.MoneyControlAPI.response.Response;

public interface LoginService {
    Response login(Login login);
    Response register(Register register);

}
