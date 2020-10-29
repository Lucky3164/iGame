package com.igame;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScans({
//        @MapperScan("com.igame.mapper.wrapper"),
        @MapperScan("com.igame.mapper")

})
@EnableCaching
public class IgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgameApplication.class, args);
    }

}
