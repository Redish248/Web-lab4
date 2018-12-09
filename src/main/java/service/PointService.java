package service;

import entity.Point;

import java.util.List;

public interface PointService {
    Point getPointByPointId(int id);
    List<Point> getPointsByR(double r);
    List<Point> getPointsBySession();
    void closeSession();
    boolean savePoint(Point point);
}
