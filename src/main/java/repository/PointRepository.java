package repository;

import entity.Point;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Integer> {
    //TODO: а это надо?
    Point findPointByPointId(int id);
    List<Point> getPointsByR(double r);
}
