package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    @JsonProperty(access = Access.READ_ONLY)
    private Collection<Point> points;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
