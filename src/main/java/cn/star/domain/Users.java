package cn.star.domain;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户类〉
 *
 * @author OneStar
 * @create 2019/11/8
 * @since 1.0.0
 */
public class Users {
    private Integer id;
    private String username;
    private String PASSWORD;
    public Users(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}