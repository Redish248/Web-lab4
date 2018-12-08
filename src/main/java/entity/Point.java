package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "point", schema = "lab4", catalog = "postgres")
public class Point implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pointId")
    Integer pointId;

    @Column(name = "x", nullable = false)
    double x;

    @Column(name = "y", nullable = false)
    double y;

    @Column(name = "r", nullable = false)
    double r;

    @Column(name = "isInArea", nullable = false)
    boolean isInArea;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = checkArea();
    }

    public boolean checkArea() {
        return true;
    }

}
