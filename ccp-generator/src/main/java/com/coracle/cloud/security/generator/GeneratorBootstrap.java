

package com.coracle.cloud.security.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author coracle
 * @email coracle@coracle.com
 * @version 2017年08月25日
 */
@SpringBootApplication
@MapperScan("com.coracle.cloud.security.generator.mapper")
public class GeneratorBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(GeneratorBootstrap.class, args);
    }
}
