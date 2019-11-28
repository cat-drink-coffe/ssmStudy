package cn.star.test;
import cn.star.service.UsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 〈一句话功能简述〉<br>
 * 〈测试类〉
 *
 * @author OneStar
 * @create 2019/11/11
 * @since 1.0.0
 */
public class springtest {
    @Test
    public void Test(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //获取对象
        UsersService us = (UsersService) ac.getBean("usersService");
        //调用方法
        us.findUsers();
    }
}