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
    public @ResponseBody ResponseEntity savePoint(@RequestParam("x") String x,
                             @RequestParam("y") String y,
                             @RequestParam("r") String r) {

        User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName());

        try {
            Point point = new Point(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r), user);
            if (pointService.savePoint(point)) {
                return ResponseEntity.status(HttpStatus.OK).body(point);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect input!");
        }
    }

    @GetMapping(value = "/getpoints")
    public @ResponseBody ResponseEntity getAllPoints() {
        User user = userService.getUserByUsername( SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.status(HttpStatus.OK).body((pointService.getPointsByUser(user)));
    }
}
