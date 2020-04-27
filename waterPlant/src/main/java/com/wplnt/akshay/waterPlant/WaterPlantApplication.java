package com.wplnt.akshay.waterPlant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class WaterPlantApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterPlantApplication.class, args);
    }

}
