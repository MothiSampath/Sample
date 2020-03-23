package com.springboot.demoapp.mapper;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.dto.UsersDTO;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersMapper {

    public Users toUser(UsersDTO usersDTO) throws Exception{
        Users users = new Users();
        users.setEmail(usersDTO.getEmail());
        users.setId(usersDTO.getId());
        users.setPassword(usersDTO.getPassword());
        users.setUserName(usersDTO.getUserName());
        users.setFileToUpload(new Binary(BsonBinarySubType.BINARY, usersDTO.getFileToUpload().getBytes()));
        return  users;
    }

    public List<UsersDTO> toUsersDto(List<Users> usersList){
        List<UsersDTO> usersDTOS = new ArrayList<>();
        usersList.stream().forEach((users) ->{
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setEmail(users.getEmail());
            usersDTO.setId(users.getId());
            usersDTO.setPassword(users.getPassword());
            usersDTO.setUserName(users.getUserName());
            usersDTOS.add(usersDTO);
        });

        return usersDTOS;
    }

    public UsersDTO toUsersDto(Users users){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setEmail(users.getEmail());
        usersDTO.setId(users.getId());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setUserName(users.getUserName());
        return usersDTO;
    }
}
