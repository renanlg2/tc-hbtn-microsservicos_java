package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @GetMapping(value = "/user-id/{id}")
    public String findUserById(@PathVariable("id") Long id){
        if ((id <=0) || (id >= 100))
            throw new UserIdException();

        return "You have entered valid ID";
    }

    @GetMapping(value = "/user-name/{username}")
    public String findUserByUserName(@PathVariable("username") String username){

        if ((username.length() <= 3) || (username.length() >= 15))
            throw new UserNameException();

        return "You have entered valid USERNAME";
    }

    @GetMapping(value = "/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable("cpf") String cpf){

        if (!isCPF(cpf))
            throw new CPFException();

        return  "You have entered valid CPF";
    }

    public boolean isCPF(String cpf) {
        if ((cpf.length() <= 3) || (cpf.length() >= 15))
            return false;

        return true;
    }

}
