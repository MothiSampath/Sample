package com.springboot.demoapp.controller;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.dto.UsersDTO;
import com.springboot.demoapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("getUsersByUserName/{userName}")
    public ResponseEntity<List<UsersDTO>> getUsersByUserName(@PathVariable String userName){
        List<UsersDTO> users = usersService.getUsersbyUserName(userName);

        return new ResponseEntity<List<UsersDTO>>(users, HttpStatus.OK);
    }

    @GetMapping("getAllUsers")
    public ResponseEntity<List<UsersDTO>> getAllUsers(){
        List<UsersDTO> users = usersService.getAllUsers();

        return new ResponseEntity<List<UsersDTO>>(users, HttpStatus.OK);
    }

    @PostMapping("saveUser")
    public ResponseEntity<String> saveUser(@ModelAttribute UsersDTO user) throws Exception{
        usersService.saveUser(user);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
