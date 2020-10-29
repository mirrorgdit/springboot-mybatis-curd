package com.example.demo.dao;

import com.example.demo.entity.GirlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface GirlDao {
    /**
     * 根据userId查询用户信息
     * @param userId  用户ID
     */
    List<GirlEntity> queryUserInfo(Long userId);

    /**
     * 查询所有用户信息
     */
    List<GirlEntity> queryAllUserInfo();

    /**
     * 添加用户
     */
    Integer addGirl(GirlEntity girl);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer delGirl(Long userId);

    /**
     * 修改信息
     * @param girl
     * @return
     */
    Integer updateGirl(GirlEntity girl);
}
