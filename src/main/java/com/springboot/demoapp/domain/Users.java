package com.springboot.demoapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Document(collection = "users")
public class Users {

    @Id
    private String id;

    private String userName;

    private String email;

    private String password;

    private Binary fileToUpload;

    private Binary pdfFile;
}
