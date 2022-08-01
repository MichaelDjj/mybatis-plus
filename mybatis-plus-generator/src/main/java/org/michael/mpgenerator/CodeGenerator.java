package org.michael.mpgenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

/**
 * 代码生成器
 * @author Dijunjie
 * @date 2022/6/7-17:07
 */
public class CodeGenerator {

    public static void main(String[] args) {
        generator();
    }

    private static void generator() {
        // 数据库配置
        String url = "jdbc:mysql://127.0.0.1:3306/mybatis_plus_starter?useSSL=false&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "123@abcd";
        DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder(url, username, password);
        String author = "Michael";

        // 代码生成器
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                //全局配置
                .globalConfig(builder -> {
                    builder.author(author) //设置作者
//                            .enableSwagger() //开启 swagger 模式
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir(System.getProperty("user.dir") + "/mybatis-plus-generator/src/main/java") //指定输出目录
                    ;
                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("org.michael.mpgenerator") //设置父包名
//                            .controller("controller") //生成controller层
                            .service("service") //生成服务层
                            .entity("entity") //生成实体层
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/mybatis-plus-generator/src/main/resources/mapper")) // 设置mapperXml生成路径
                    ;
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_user") //设置需要生成的表名
                            .addTablePrefix("t_", "c_") //设置过滤表前缀
                            .entityBuilder() //开启实体类配置
                            .enableLombok() //开启lombok
                            .enableChainModel() //lombok链式操作
                            .naming(NamingStrategy.underline_to_camel) //下划线转驼峰命名
                            .columnNaming(NamingStrategy.underline_to_camel) //下划线转驼峰命名
                            .addSuperEntityColumns("id") //super类字段
                    ;
                })
                .templateEngine(new VelocityTemplateEngine()) //使用Velocity引擎模板
                .execute();
    }

}
