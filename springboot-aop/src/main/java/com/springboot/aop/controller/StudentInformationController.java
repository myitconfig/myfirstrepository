package com.springboot.aop.controller;

import com.springboot.aop.entity.TStu;
import com.springboot.aop.service.TStuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TStu)表控制层
 *
 * @author makejava
 * @since 2020-04-10 09:21:10
 */
@RestController
@RequestMapping("tStu")
public class StudentInformationController {
    /**
     * 服务对象
     */
    @Resource
    private TStuService tStuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TStu selectOne(Integer id) {
        return this.tStuService.queryById(id);
    }

}