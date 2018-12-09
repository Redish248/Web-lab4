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
@RequestMapping("/registration")
@EnableAutoConfiguration
public class RegistrationController {

   @Autowired
    UserService userService;
    //TODO:
    //-почему девочки такие тупые?
    //-не знаю
    //-прикинь, некоторые люди ещё тупее. Как они с этим живут?
    //@Оля
    @PostMapping("/checkUser")
    public @ResponseBody ResponseEntity checkUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        //User realUser = userService.getUserByNickAndPassword(login, BCrypt.hashpw(password, BCrypt.gensalt()));
        boolean pswd = BCrypt.checkpw(password,userService.getUserByNick(login).getPassword());

        if ((login == null) ||(password == null) || (!pswd)) {
            return ResponseEntity.status(HttpStatus.OK).body("Username or password was incorrect");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Successful authentication");
    }

    @PostMapping( "/addUser")
    public @ResponseBody ResponseEntity registerUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = new User(login, BCrypt.hashpw(password, BCrypt.gensalt()));
        if ((login == null) || (password == null)) {
            return ResponseEntity.status(HttpStatus.OK).body("Incorrect nick or password");
        }
        User someUser = userService.getUserByNick(login);
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body("User already exists");
        }
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(user));
    }
}
