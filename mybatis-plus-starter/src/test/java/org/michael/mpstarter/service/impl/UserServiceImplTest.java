package org.michael.mpstarter.service.impl;

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


}