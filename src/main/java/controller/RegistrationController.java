package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/registration")
@EnableAutoConfiguration
public class RegistrationController {

   @Autowired
    UserService userService;

    @PostMapping("/checkUser")
    ResponseEntity<?> checkUser(@RequestBody User user) {
        User realUser = userService.getUserByNickAndPassword(user.getNick(), user.getPassword());

        if (realUser == null || (user.getNick() == null) ||(user.getPassword() == null)) {
            return ResponseEntity.status(HttpStatus.OK).body("Username or password was incorrect");
        }
        //TOdO: что надо возвращать?
        return ResponseEntity.status(HttpStatus.OK).body("log in");
    }

    @PostMapping( "/addUser")
    ResponseEntity<?> registerUser(@RequestBody User user) {
        if ((user.getNick() == null) ||(user.getPassword() == null)) {
            return ResponseEntity.status(HttpStatus.OK).body("Incorrect nick or password");
        }
        User someUser = userService.getUserByNick(user.getNick());
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
