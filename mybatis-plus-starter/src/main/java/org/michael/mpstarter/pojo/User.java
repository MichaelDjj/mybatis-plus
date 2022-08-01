package org.michael.mpstarter.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.LocalDateTime;

/**
 * @author dijunjie
 */
@Data
@Builder
@TableName("t_user")
public class User {
//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;

    //逻辑删除位
//    @TableLogic(value = "1", delval = "0")
    private Integer enabled;

    //填充策略: DateTimeMetaObjectHandler
    //创建时间，添加数据时填充=当前时间
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;
    //更新时间，添加、更新数据时填充=当前时间
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDateTime;

    @Version
    private Integer version;

    @Tolerate
    public User() {}
}
