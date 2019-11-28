package cn.star.test;

import cn.star.domain.Users;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) {
        Users u1 = new Users();
        u1.setId(1);
        u1.setUsername("原东朝1");
        u1.setPASSWORD("1234567");
        Users u2 = new Users();
        u2.setId(2);
        u2.setUsername("原东朝2");
        u2.setPASSWORD("1234567");
        Users u3 = new Users();
        u3.setId(3);
        u3.setUsername("原东朝3");
        u3.setPASSWORD("1234567");
        List list = new ArrayList();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        String s = JSON.toJSONString(list);
        System.out.println(s);
        Map map = new HashMap();
        map.put("u1",u1);
        map.put("u2",u2);
        map.put("u3",u3);
        System.out.println("//////////////////////////////");
        String s1 = JSON.toJSONString(map);
        System.out.println(s1);
        String[] str = {"q","a","z"};
        System.out.println(str.toString());
        String s2 = ArrayUtils.toString(str, ",");
        System.out.println(s2); // {0,1,2,3,4,5}
        String[] arr = { "0", "1", "2", "3", "4", "5" };
        String str4 = StringUtils.join(str,","); // 数组转字符串(逗号分隔)(推荐)
        System.out.println(str4); // 0,1,2,3,4,5
    }

}
