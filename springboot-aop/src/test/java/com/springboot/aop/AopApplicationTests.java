package com.springboot.aop;

import com.springboot.aop.entity.TStu;
import com.springboot.aop.service.TStuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AopApplicationTests {

    @Resource
    private TStuService tStuService;

    @Test
    void insertForeach() {
        List<TStu> stuList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TStu tStu=new TStu();
            tStu.setUserName("赵六"+i);
            tStu.setClassId(3);
            stuList.add(tStu);
        }
        System.out.println(tStuService.insert(stuList));
    }

    @Test
    void testReflect() throws ClassNotFoundException {
        TStu tStu=new TStu();
        System.out.println(tStu.getClass().getName());
        System.out.println(Class.forName("com.springboot.aop.entity.TStu").getName());
        System.out.println(TStu.class.getName());


    }

}
