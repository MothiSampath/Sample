package com.springboot.demoapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public class Users {

    @Id
    private String id;

    private String userName;

    private String email;

    private String password;

}
