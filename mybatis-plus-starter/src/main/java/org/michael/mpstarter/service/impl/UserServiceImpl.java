package org.michael.mpstarter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.michael.mpstarter.mapper.UserMapper;
import org.michael.mpstarter.pojo.User;
import org.michael.mpstarter.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mybatis-plus service实现类需要extends通用实现类ServiceImpl
 *
 * @author dijunjie
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {

    //利用wrapper作条件查询
    public List<User> selectByName(String userName) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        //1.常规写法
//        Wrapper<User> eq = userQueryWrapper
//                .select("id", "name", "age", "email") //查询哪些字段
//                .eq("name", userName); //where name = ?
        //2.lambda
        Wrapper<User> eq = userQueryWrapper
                .lambda()
                .select(User::getId, User::getName, User::getAge, User::getEmail) //查询哪些字段
                .eq(User::getName, userName); //where name = ?

        return list(eq);
    }

    public int updateNameById(String userName, long id) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        /*LambdaUpdateWrapper<User> in = userUpdateWrapper.lambda()
                .set(User::getName, userName) //set name = ?
//                .setSql("name = '"+userName+"'")
                .in(User::getId, id); //where id in (?)
        //update(T t,Wrapper updateWrapper)时t不能为空,否则自动填充失效
        //这里update方法t=null，无法自动填充
        return update(in) ? 1 : 0;*/

        //update(T t, Wrapper whereWrapper)可以使用自动填充
        LambdaUpdateWrapper<User> whereWrapper = userUpdateWrapper.lambda().eq(User::getId, id);
        User build = User.builder().name(userName).build();
        return update(build,whereWrapper) ? 1 : 0;
    }

}
