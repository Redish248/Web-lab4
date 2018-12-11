package impl;

import entity.Point;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PointRepository;
import service.PointService;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
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
    public List<Point> getPointsByUser(User user) {
        return pointRepository.getPointsByUser(user);
    }

    @Override
    public boolean savePoint(Point point) {
        if (point.getR() <= 0 || point.getR() > 3 || point.getX() < -5 || point.getX() > 3 || point.getY() < -5 || point.getY() > 5) return false;
        pointRepository.save(point);
        return true;
    }
}
