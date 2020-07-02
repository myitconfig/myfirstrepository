package com.springboot.aop.dao;

import com.springboot.aop.entity.TStu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TStu)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-10 09:21:10
 */
public interface TStuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userCode 主键
     * @return 实例对象
     */
    TStu queryById(Integer userCode);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TStu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tStu 实例对象
     * @return 对象列表
     */
    List<TStu> queryAll(TStu tStu);

    /**
     * 新增数据(单条插入,批量插入)
     *
     * @param stuList 实例对象集合
     * @return 影响行数
     */
      int insert(@Param("stuList") List<TStu> stuList);


    /**
     * 修改数据
     *
     * @param tStu 实例对象
     * @return 影响行数
     */
    int update(TStu tStu);

    /**
     * 通过主键删除数据
     *
     * @param userCode 主键
     * @return 影响行数
     */
    int deleteById(Integer userCode);

}