package org.michael.mpstarter.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author dijunjie
 */
@Component
public class DateTimeMetaObjectHandler implements MetaObjectHandler {

    //插入=当前时间
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createDateTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, "modifyDateTime", LocalDateTime.class, LocalDateTime.now());
    }

    //更新=当前时间
    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "modifyDateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
