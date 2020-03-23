package com.springboot.demoapp.controller;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.dto.UsersDTO;
import com.springboot.demoapp.service.UsersService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        usersService.deleteUser(id);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

//    @GetMapping( value = "getUserAttachment/{id}",
//              produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @GetMapping(value = "getUserAttachment/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getAttachmentByUserId(@PathVariable String id){
        Binary file = usersService.getUserAttachment(id);
        return file.getData();
    }
}
