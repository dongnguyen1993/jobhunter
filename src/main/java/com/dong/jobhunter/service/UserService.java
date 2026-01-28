package com.dong.jobhunter.service;

import com.dong.jobhunter.domain.User;
import com.dong.jobhunter.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById((long) id).orElse(null);
    }

    public User createNewUser(User userRequest) {

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());

        userRepository.save(user);

        return user;
    }

    public User updateUser(Long id, User userRequest) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setEmail(userRequest.getEmail());
            user.setName(userRequest.getName());
            user.setPassword(userRequest.getPassword());
            userRepository.save(user);
        }
        return user;
    }

    public User deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }
}
