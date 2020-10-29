package com.example.demo.service.impl;

import com.example.demo.dao.GirlDao;
import com.example.demo.entity.GirlEntity;
import com.example.demo.service.GirlService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;

    /**
     * 查询用户的所有菜单ID
     *
     * @param userId
     * @return
     */
    @Override
    public List<GirlEntity> queryUserInfo(Long userId) {
        return girlDao.queryUserInfo(userId);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public Object  queryAllUserInfo(int page, int size) {

        PageHelper.startPage(page, size);
        List<GirlEntity> list = girlDao.queryAllUserInfo();
        PageInfo<GirlEntity> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @Override
    public int addGirl(GirlEntity girl) {
        return girlDao.addGirl(girl);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int delGirl(Long userId) {
        return girlDao.delGirl(userId);
    }

    /**
     * 修改信息
     * @param girl
     * @return
     */
    public int updateGirl(GirlEntity girl) {
        return girlDao.updateGirl(girl);
    }
}