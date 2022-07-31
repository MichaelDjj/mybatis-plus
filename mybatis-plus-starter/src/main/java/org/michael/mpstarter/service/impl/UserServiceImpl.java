package org.michael.mpstarter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.michael.mpstarter.mapper.UserMapper;
import org.michael.mpstarter.pojo.User;
import org.michael.mpstarter.service.UserService;
import org.springframework.stereotype.Service;

/**
 * mybatis-plus service实现类需要extends通用实现类ServiceImpl
 *
 * @author dijunjie
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {
}
