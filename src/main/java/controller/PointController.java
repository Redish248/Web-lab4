package controller;

import com.google.gson.Gson;
import entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PointService;

@RestController
@RequestMapping("/checkPoint")
@EnableAutoConfiguration
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity savePoint(@RequestParam("x") String x,
                             @RequestParam("y") String y,
                             @RequestParam("r") String r) {
        Point point = new Point(Double.parseDouble(x), Double.parseDouble(y), Double.parseDouble(r));

        if (pointService.savePoint(point)) {
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(point));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Incorrect input!");
        }
    }

    @GetMapping(value = "/points")
    public @ResponseBody ResponseEntity getAllPoints() {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(pointService.getPointsBySession()));
    }

    @PostMapping(value="/logout")
    public @ResponseBody ResponseEntity logOut(){
        pointService.closeSession();
        return ResponseEntity.status(HttpStatus.OK).body("Session closed");
    }
}
