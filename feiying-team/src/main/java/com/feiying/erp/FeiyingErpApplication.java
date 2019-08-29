package com.feiying.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.feiying.erp.datasource.mappers"})
@ServletComponentScan
@EnableScheduling
public class FeiyingErpApplication{
    public static void main(String[] args) {
        SpringApplication.run(FeiyingErpApplication.class, args);
    }
}
