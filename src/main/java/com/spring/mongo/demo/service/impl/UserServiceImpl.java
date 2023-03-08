package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.dto.UserDTO;
import com.spring.mongo.demo.model.User;
import com.spring.mongo.demo.repository.UserRepository;
import com.spring.mongo.demo.service.LikeService;
import com.spring.mongo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private LikeService likeService;


    @Override
    public User create(UserDTO item) {
        User user = new User();
        user.setFirstName(item.getFirstName());
        user.setLastName(item.getLastName());
        user.setUserName(item.getUserName());
        user.setPassword(item.getPassword());

        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(String id) {
       repository.findById(id).ifPresent(user -> {
           likeService.deleteAllByUserId(id);
           repository.delete(user);
       });
    }
}
