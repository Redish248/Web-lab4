package impl;

import entity.Point;
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
    private final HttpSession httpSession;


    @Autowired
    public PointServiceImpl(PointRepository pointRepository, HttpSession session) {
        this.pointRepository = pointRepository;
        httpSession = session;
    }

    public Point getPointByPointId(int id) {
        return pointRepository.findPointByPointId(id);
    }

    public List<Point> getPointsByR(double r) {
        return pointRepository.getPointsByR(r);
    }

    @Override
    public List<Point> getPointsBySession() {
        return (List<Point>) pointRepository.getPointsBySessionId(httpSession.getId());
    }

    @Transactional
    @Override
    public void closeSession() {
        String s = httpSession.getId();
        httpSession.invalidate();
        pointRepository.deleteAllBySessionId(s);
    }

    @Override
    public boolean savePoint(Point point) {
        if (point.getR() <= 0 || point.getR() > 3 || point.getX() < -5 || point.getX() > 3 || point.getY() < -5 || point.getY() > 5) return false;
        point.setSessionId(httpSession.getId());
        pointRepository.save(point);
        return true;
    }
}
