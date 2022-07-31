package org.michael.mpstarter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.michael.mpstarter.pojo.User;

/**
 * @author dijunjie
 */
public interface UserMapper extends BaseMapper<User> {  //BaseMapper是mybatis-plus基础Mapper类，有基础crud操作

    /**
     * 根据用户name分页查询
     * @param userPage
     * @param userName
     * @return
     */
    IPage<User> pageByName(IPage<User> userPage, @Param("name") String userName);

}
