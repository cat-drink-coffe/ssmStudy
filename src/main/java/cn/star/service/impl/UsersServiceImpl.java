package cn.star.service.impl;
import cn.star.dao.UsersDao;
import cn.star.domain.Users;
import cn.star.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

import java.util.List;
/**
 * 〈一句话功能简述〉<br>
 * 〈Service 实现类〉
 *
 * @author OneStar
 * @create 2019/11/9
 * @since 1.0.0
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findUsers() {
        System.out.println("业务层：查询用户");
        return usersDao.findUsers();
    }

    @Override
    public void insertUsers(Users users) {
        System.out.println("业务层：用户注册");
        usersDao.insertUsers(users);
    }

    @Override
    public boolean login(Users users) {
        System.out.println("业务层：用户登录");
        if(usersDao.login(users) == null){
            return false;
        }else{
            return true;
        }
    }

    private String filePath="E:/img/"; //定义上传文件的存放位置
    @Override
    public void upLoadFile(MultipartFile upload) {

        String fileName = upload.getOriginalFilename();  //获取上传文件的名字
        //判断文件夹是否存在,不存在则创建
        File file=new File(filePath);

        if(!file.exists()){
            file.mkdirs();
        }

        String newFilePath=filePath+fileName; //新文件的路径

        try {
            upload.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        System.out.println("删除id="+id);
        usersDao.deleteUser(id);
    }
}