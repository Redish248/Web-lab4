package controller;

import entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PointService;

@RestController
@RequestMapping(value = "/checkPoint")
@EnableAutoConfiguration
public class PointController {

    @Autowired
    PointService pointService;

    @PostMapping(value = "/points")
    ResponseEntity<?> sendPoint(@RequestBody Point point ) {
        if (point.getR() <= 0 || point.getR() > 3) {
            return ResponseEntity.status(HttpStatus.OK).body("R incorrect");
        }

        if (point.getX() < -5 || point.getX() > 3) {
            return ResponseEntity.status(HttpStatus.OK).body("X incorrect");
        }

        if (point.getY() < -5 || point.getY() > 5) {
            return ResponseEntity.status(HttpStatus.OK).body("Y incorrect");
        }

        pointService.savePoint(point);
        return ResponseEntity.status(HttpStatus.OK).body(point);
    }

    @GetMapping(value = "/points")
    ResponseEntity<?> getAllPoints() {
        return ResponseEntity.status(HttpStatus.OK).body(pointService.getAllPoints());
    }

}
