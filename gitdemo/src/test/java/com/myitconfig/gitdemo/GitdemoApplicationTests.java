package com.myitconfig.gitdemo;

import com.myitconfig.gitdemo.component.JavaMailComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GitdemoApplicationTests {

    @Autowired
    private JavaMailComponent javaMailComponent;

    @Test
    void contextLoads() {
        this.javaMailComponent.sendMail("1357604648@qq.com");
    }

}
