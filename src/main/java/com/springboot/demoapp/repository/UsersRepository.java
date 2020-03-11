package com.springboot.demoapp.repository;

import com.springboot.demoapp.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users , String> {
}
