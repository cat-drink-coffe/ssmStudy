package cn.star.dao;
import cn.star.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 〈一句话功能简述〉<br>
 * 〈数据访问层 UsersDao 接口〉
 *
 * @author OneStar
 * @create 2019/11/8
 * @since 1.0.0
 */

@Repository

public interface UsersDao {
    //查询所有用户cn.star.dao.UsersDao.findUsers
    //@Select("select * from users")
    public List<Users> findUsers();

    //用户注册
    @Insert("INSERT INTO USERS (username,PASSWORD) VALUES(#{username},#{PASSWORD})")
    public void insertUsers(Users users);

    //用户登录
    @Select("select * from users where username=#{username} and PASSWORD=#{PASSWORD}")
    public Users login(Users users);

    public void deleteUser(int id);
}