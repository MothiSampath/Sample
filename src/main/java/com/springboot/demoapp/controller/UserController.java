package com.springboot.demoapp.controller;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("getUsersByUserName/{userName}")
    public ResponseEntity<List<Users>> getUsersByUserName(@PathVariable String userName){
        List<Users> users = usersService.getUsersbyUserName(userName);

        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }
}
