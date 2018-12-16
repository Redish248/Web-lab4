package controller;

import entity.Point;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import service.PointService;
import service.UserService;

@RestController
@RequestMapping("/lab4")
@EnableAutoConfiguration
public class PointController {

    final PointService pointService;

    @Autowired
    private UserService userService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/savepoint")
    public @ResponseBody ResponseEntity savePoint(@RequestParam("x") double x,
                             @RequestParam("y") double y,
                             @RequestParam("r") double r) {

        User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName());

        Point point = new Point(x,y,r, user);

        if (pointService.savePoint(point)) {
            return ResponseEntity.status(HttpStatus.OK).body(point);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect input!");
        }
    }

    @GetMapping(value = "/getpoints")
    public @ResponseBody ResponseEntity getAllPoints() {
        User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.status(HttpStatus.OK).body((pointService.getPointsByUser(user)));
    }
}
