package com.example.demo.mapper;


import com.example.demo.entity.GirlEntity;
import com.example.demo.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlTest {
    private Logger logger = LoggerFactory.getLogger(GirlTest.class);
    @Autowired
    private GirlService girlService;

    @Test
    public void queryUserInfo() throws Exception {
        GirlEntity girlEntity = new GirlEntity();
        girlEntity.setUserId(1L);
        List<GirlEntity> list = girlService.queryUserInfo(girlEntity.getUserId());
        logger.info("list:" + list);
    }

    @Test
    public void queryAllUserInfo() throws Exception {
        Object  lists = girlService.queryAllUserInfo(1,2);
        logger.info("alllist:" + lists);
    }

    @Test
    public void addGirl() throws Exception {
        GirlEntity girl = new GirlEntity();
        girl.setUsername("uhuibao1");
        String pwd = "123456";
        String md5Password = DigestUtils.md5DigestAsHex(pwd.getBytes());
        girl.setPassword(md5Password);
        girl.setSalt("uhuibao1uhuibao1");
        girl.setEmail("huangzj@huibao.com");
        girl.setStatus(1);
        girl.setMobile("18682312720");
        girlService.addGirl(girl);
        System.out.println("添加成功");

    }

    @Test
    public void delGirl() throws Exception {
        girlService.delGirl(8L);
        System.out.println("删除成功");
    }

    @Test
    public void updateGirl() throws Exception {
        GirlEntity girl = new GirlEntity();
        girl.setUserId(4L);
        girl.setUsername("uhuibao");
        girl.setMobile("18682312720");
        girlService.updateGirl(girl);
        System.out.println("修改成功");

    }

}
