package com.springboot.demoapp.service;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.dto.UsersDTO;
import com.springboot.demoapp.mapper.UsersMapper;
import com.springboot.demoapp.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UsersMapper usersMapper;

    @Value("${user.service.name}")
    private String message;

    public List<UsersDTO> getUsersbyUserName(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").regex("^"+userName));

        List<Users> users = mongoTemplate.find(query , Users.class);
        List<UsersDTO> usersDTOS = usersMapper.toUsersDto(users);
        return usersDTOS;
    }

    public List<UsersDTO> getAllUsers(){
        log.info("from Property >>>>>"+message);
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> usersDTOS = usersMapper.toUsersDto(users);
        return usersDTOS;
    }

    public void saveUser(UsersDTO user) throws Exception{
        Users userDomain = usersMapper.toUser(user);
        usersRepository.save(userDomain);
    }

    public void deleteUser(String id){
        usersRepository.deleteById(id);
    }

    public Binary getUserAttachment(String id){
        Users users = usersRepository.findById(id).get();
        Binary file = users.getFileToUpload();
        return file;
    }

}
