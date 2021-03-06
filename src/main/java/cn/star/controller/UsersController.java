package cn.star.controller;

import cn.star.domain.Users;
import cn.star.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户控制层〉
 *
 * @author OneStar
 * @create 2019/11/9
 * @since 1.0.0
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 查询用户集合
     *
     * @param model
     * @return
     */
    @RequestMapping("/findUsers")
    public String findUsers(Model model) {
        System.out.println("表现层：查询用户");
        //调用service对象的方法进行测试
        List<Users> list = usersService.findUsers();
        model.addAttribute("list", list);
        return "Users";
    }

    /**
     * 通过ID查询用户
     *
     * @param model
     * @return
     */
    @RequestMapping("/findUserById")
    public String findUserById(int id,Model model) {
        System.out.println("表现层：查询用户");
        //调用service对象的方法进行测试
        Users user = usersService.findUserById(id);
        model.addAttribute("user", user);
        return "detail";
    }

    /**
     * 用户注册
     *
     * @param users
     * @return
     */
    @RequestMapping("/insert")
    public String insert(Users users,Model model) {
        System.out.println("注册");
        // 调用注入的 usersService 调用 insertUsers 方法
        usersService.insertUsers(users);
        return "forward:/users/findUsers";
    }

    /**
     * 用户登录
     *
     * @param users
     * @return
     */
    @RequestMapping("/login")
    public String login(Users users) {
        System.out.println("登录");
        // 调用注入的 usersService 调用 login 方法
        if (usersService.login(users)) {
            return "successlogin";
        } else {
            return "falselogin";
        }
    }


    /**
     * 图片上传
     *
     * @param upload
     * @return
     */
    @RequestMapping("/saveImg")
    @ResponseBody
    public String saveImg(MultipartFile upload) {
        usersService.upLoadFile(upload);
        return "falselogin";
    }
    /**
     * 删除
     * @param id
     */
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        System.out.println("删除id="+id);
        usersService.deleteUser(id);
        return "forward:/users/findUsers";
    }

    /**
     * 编辑
     * @param id
     * @param model
     */
    @RequestMapping("/edit")
    public String  editUserById(@RequestParam("id") int id ,Model model) {
        System.out.println("表现层：查询用户");
        //调用service对象的方法进行测试
        Users user = usersService.editUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @RequestMapping("/addgo")
    public ModelAndView addgo() {
        ModelAndView mav = new ModelAndView("add");
        return mav;
    }

}
