package cn.star.service;
import cn.star.domain.Users;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;
/**
 * 〈一句话功能简述〉<br>
 * 〈业务层接口〉
 *
 * @author OneStar
 * @create 2019/11/9
 * @since 1.0.0
 */
public interface UsersService {
    //查询所有用户
    public List<Users> findUsers();
    //用户注册
    public void insertUsers(Users users);
    //用户登录
    public boolean login(Users users);
    //wenjainshanghcuan
    void upLoadFile(MultipartFile upload);
    public void deleteUser(int id);
}