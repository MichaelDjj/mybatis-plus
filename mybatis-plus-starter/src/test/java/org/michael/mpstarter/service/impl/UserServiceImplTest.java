package org.michael.mpstarter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.michael.mpstarter.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * CRUD servier接口测试
 * 官网用例：
 * https://baomidou.com/pages/49cc81/#service-crud-%E6%8E%A5%E5%8F%A3
 *
 * @author dijunjie
 */
@Slf4j
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void save() {
        User user = User.builder()
                .name("wang5")
                .age(28)
                .email("ddd")
                .build();
        userService.save(user);
    }

    @Test
    void query() {
        User user = userService.getById(5L);
        log.debug("{}",user);
    }

    @Test
    void page() {
        Page<User> userPage = new Page<>(2, 3);
        Page<User> page = userService.page(userPage);
        List<User> records = page.getRecords();

        log.debug("page 查询结果: {}",records);
        log.debug("page 总数:{}， 当前页:{}， 每页显示条数;{}",page.getTotal(),page.getCurrent(),page.getSize());
    }

    @Test
    void selectByName() {
        List<User> list = userService.selectByName("zhangsan");
        log.debug("selectByName :{}", list);
    }

    @Test
    void updateNameById() {
        int result = userService.updateNameById("zhang3", 8L);
        log.debug("updateNameById {}",result);
    }

    @Test
    void testUpdateCAS() {
        User before = userService.getById(8L);
        before.setName("zhang3");
        LambdaUpdateWrapper<User> whereWrapper = new UpdateWrapper<User>().lambda().eq(User::getId, 8L);
        //乐观锁version+1仅支持 updateById(id) 与 update(entity, wrapper) 方法。
        //并且必须在当前entity 获取到version，然后执行cas操作后才能update成功
        userService.update(before, whereWrapper);
    }

    @Test
    void logicDelete() {
        User build = User.builder()
                .id(7L)
                .build();

        boolean b = userService.removeById(build);

        log.debug("logicDelete: {}", b);

    }


}