package com.example.javatgbot.dao.repository;

import com.example.javatgbot.dao.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
}
