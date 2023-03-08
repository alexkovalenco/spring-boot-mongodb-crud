package com.spring.mongo.demo.service;

import com.spring.mongo.demo.dto.UserDTO;
import com.spring.mongo.demo.model.User;

import java.util.List;

public interface UserService {

    User create(UserDTO item);

    List<?> findAll();

    User findById(String id);

    User save(User user);

    User update(User user);

    void delete(String id);
}
