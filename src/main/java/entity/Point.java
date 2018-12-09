package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "pointlab", schema = "public", catalog = "postgres")
public class Point implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_Id")
    Integer pointId;

    @Column(name = "x", nullable = false)
    double x;

    @Column(name = "y", nullable = false)
    double y;

    @Column(name = "r", nullable = false)
    double r;

    @Column(name = "is_In_Area", nullable = false)
    boolean isInArea;

    @Column(name = "session_Id", nullable = false)
    private String sessionId;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = checkArea();
    }

    private boolean checkArea() {
        return  (((x>=0) && (y>=0) && (Math.pow(x,2)+Math.pow(y,2)<=Math.pow(r,2))) ||
                ((x>=0) && (y<=0) && (x<=r/2) && (y>=-r)) ||
                ((x<=0) && (y>=0) && (y<=(x+r)/2)));
    }

}
