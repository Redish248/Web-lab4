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
@Table(name = "user", schema = "lab4", catalog = "postgres")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    Integer id;

    @Column(name = "nick", nullable = false, length = 40)
    String nick;

    @Column(name = "password", nullable = false, length = 40)
    String password;

    public User(String nick, String password) {
        this.nick = nick;
        this.password = getMD5(password);
    }


    private static String getMD5(String pass) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(pass.getBytes(),0, pass.length());
            String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
            if (hashedPass.length() < 32) {
                hashedPass = "0" + hashedPass;
            }
            return hashedPass;
        } catch (NoSuchAlgorithmException exc) {
            return null;
        }
    }
}
