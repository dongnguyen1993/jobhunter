package com.dong.jobhunter.controller;

import com.dong.jobhunter.domain.User;
import com.dong.jobhunter.service.UserService;
import com.dong.jobhunter.service.error.IdInvalidException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getUserById(id.intValue()));
    }

    @PostMapping("")
    public ResponseEntity<User> createNewUser(@RequestBody User userRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createNewUser(userRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
            throws IdInvalidException {
        if (id >= 1500) {
            throw new IdInvalidException("Id khong lon hon 1500");
        }
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Deleted Successfully");
    }
}
