package impl;

import entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PointRepository;
import service.PointService;

import java.util.List;

@Service("pointService")
public class PointServiceImpl implements PointService{

    private final PointRepository pointRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public Point getPointByPointId(int id) {
        return pointRepository.findPointByPointId(id);
    }

    public List<Point> getPointsByR(double r) {
        return pointRepository.getPointsByR(r);
    }

    @Override
    public List<Point> getAllPoints() {
        return (List<Point>) pointRepository.findAll();
    }

    @Override
    public void savePoint(Point point) {
        pointRepository.save(point);
    }
}
