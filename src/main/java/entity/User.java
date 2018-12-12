package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@Table(name = "userlab", schema = "public", catalog = "postgres")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private Integer id;

    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @OneToMany(mappedBy = "user")
    private Collection<Point> points;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
