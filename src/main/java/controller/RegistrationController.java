package controller;

import com.google.gson.Gson;
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
    @PostMapping("/signin")
    public @ResponseBody ResponseEntity checkUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        boolean pswd = BCrypt.checkpw(password,userService.getUserByUsername(username).getPassword());

        if ((username == null) ||(password == null) || (!pswd)) {
            return ResponseEntity.status(HttpStatus.OK).body("Username or password was incorrect");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Successful authentication");
    }

    @PostMapping( "/signup")
    public @ResponseBody ResponseEntity registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()));
        if ((username == null) || (password == null)) {
            return ResponseEntity.status(HttpStatus.OK).body("Incorrect username or password");
        }
        User someUser = userService.getUserByUsername(username);
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(user));
    }
}