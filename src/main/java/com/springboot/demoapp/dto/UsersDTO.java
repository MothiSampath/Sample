package com.springboot.demoapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UsersDTO {

    private String id;

    private String userName;

    private String email;

    private String password;

    private MultipartFile fileToUpload;

    private MultipartFile pdfFile;
}
