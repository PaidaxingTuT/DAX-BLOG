package com.daxtech.daxblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DaxblogApplicationTests {

    @Test
    void contextLoads() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
    }

}
