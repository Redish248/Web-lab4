package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Entity
@Data
@NoArgsConstructor
@Table(name = "userlab", schema = "public", catalog = "postgres")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    Integer id;

    @Column(name = "nick", nullable = false, length = 40)
    String nick;

    @Column(name = "password", nullable = false, length = 40)
    String password;

    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }
}
