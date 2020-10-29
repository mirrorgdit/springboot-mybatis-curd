package com.example.demo.service;

import com.example.demo.entity.GirlEntity;

import java.util.List;

public interface GirlService {
    /**
     * 查询用户的所有菜单ID
     */
    List<GirlEntity> queryUserInfo(Long userId);

    /**
     * 查询所有用户信息
     */
    Object queryAllUserInfo(int page, int size);

    /**
     * 添加用户
     *
     * @param GirlEntity
     * @return
     */
    int addGirl(GirlEntity girl);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int delGirl(Long userId);

    /**
     * 更新用户
     * @param girl
     * @return
     */
    int updateGirl(GirlEntity girl);

}
