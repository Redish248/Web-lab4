package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/lab4")
@EnableAutoConfiguration
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping( "/signup")
    public @ResponseBody ResponseEntity registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
        if ((username == "") || (password == "")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect username or password");
        }
        User someUser = userService.getUserByUsername(username);
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}