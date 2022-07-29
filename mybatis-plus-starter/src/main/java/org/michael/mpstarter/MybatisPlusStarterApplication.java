package org.michael.mpstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author dijunjie
 */
@SpringBootApplication
@EnableOpenApi
public class MybatisPlusStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusStarterApplication.class, args);
    }

}
