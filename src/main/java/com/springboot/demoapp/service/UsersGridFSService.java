package com.springboot.demoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsersGridFSService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

}
