package com.springboot.demoapp.service;

import com.springboot.demoapp.domain.Users;
import com.springboot.demoapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Users> getUsersbyUserName(String userName){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").regex("^"+userName));

        List<Users> users = mongoTemplate.find(query , Users.class);

        return users;
    }

}
