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
        if ((Double.valueOf(r) <= 0) || (Double.valueOf(r) > 3)) {
            return ResponseEntity.status(HttpStatus.OK).body("R incorrect");
        }

        if ((Double.valueOf(x) < -5) || (Double.valueOf(x) > 3)) {
            return ResponseEntity.status(HttpStatus.OK).body("X incorrect");
        }

        if ((Double.valueOf(y) < -5) || (Double.valueOf(y) > 5)) {
            return ResponseEntity.status(HttpStatus.OK).body("Y incorrect");
        }
        Point point = new Point();
        point.setX(Double.parseDouble(x));
        point.setY(Double.parseDouble(y));
        point.setR(Double.parseDouble(r));
        point.setInArea(point.checkArea());

        pointService.savePoint(point);
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(point));
    }

    //TODO: find by session id
    @GetMapping(value = "/points")
    public @ResponseBody ResponseEntity getAllPoints() {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(pointService.getAllPoints()));
    }

}
