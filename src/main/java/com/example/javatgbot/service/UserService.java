package com.example.javatgbot.service;

import com.example.javatgbot.dao.entity.User;
import com.example.javatgbot.dao.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.grizzly.http.util.TimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User registerUser(Message msg){
        if(userRepository.findById(msg.getChatId()).isEmpty()){

            var chatId = msg.getChatId();
            var chat = msg.getChat();

            User user = new User();

            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUserName(chat.getUserName());
            user.setRegisteredAt(LocalDate.now());

            userRepository.save(user);
            log.info("user saved: " + user);
            return user;
        }
        return null;
    }

}
