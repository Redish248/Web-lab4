package service;

import entity.Point;
import entity.User;

import java.util.List;

public interface PointService {
    Point getPointByPointId(int id);
    List<Point> getPointsByR(double r);
    List<Point> getPointsByUser(User user);
    boolean savePoint(Point point);
}
