package org.michael.mpstarter;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.michael.mpstarter.mapper.UserMapper;
import org.michael.mpstarter.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author dijunjie
 */
@Slf4j
@SpringBootTest
class MybatisPlusStarterApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        //select * from t_user where id=1
        User user = userMapper.selectById(1);
        System.out.println(user);
        //select * from t_user
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testInsert() {
        User user = new User();
        //mp默认ID策略为ASSIGN_ID，雪花算法得到Id。
        //数据库主键为自增，需要设置id类型=AUTO
        user.setId(null);
        user.setAge(37);
        user.setName("zhangsan");
        user.setEmail("sdjfiowejfo@qq.com");
        int insertCount = userMapper.insert(user);
        System.out.println(insertCount);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setName("lisi");
        int updateCount = userMapper.updateById(user);
        System.out.println(updateCount);
    }

    @Test
    void testDelete() {
        User user = new User();
        user.setId(6L);
        int i = userMapper.deleteById(user);
        System.out.println(i);
    }

    @Test
    void testSelectMap() {
        List<User> usersList = userMapper.selectByMap(
                Maps.newHashMap("name", "zhangsan")
        );
        System.out.println(usersList);
    }



}