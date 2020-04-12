package com.springboot.aop.service.impl;

import com.springboot.aop.entity.TStu;
import com.springboot.aop.dao.TStuDao;
import com.springboot.aop.service.TStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TStu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-10 09:21:10
 */
@Service("tStuService")
public class TStuServiceImpl implements TStuService {
    @Resource
    private TStuDao tStuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userCode 主键
     * @return 实例对象
     */
    @Override
    public TStu queryById(Integer userCode) {
        return this.tStuDao.queryById(userCode);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TStu> queryAllByLimit(int offset, int limit) {
        return this.tStuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tStu 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(List<TStu> stuList) {
        return this.tStuDao.insert(stuList);
    }

    /**
     * 修改数据
     *
     * @param tStu 实例对象
     * @return 实例对象
     */
    @Override
    public TStu update(TStu tStu) {
        this.tStuDao.update(tStu);
        return this.queryById(tStu.getUserCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param userCode 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userCode) {
        return this.tStuDao.deleteById(userCode) > 0;
    }
}