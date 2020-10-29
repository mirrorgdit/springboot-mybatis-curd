package com.example.demo.controller;


import com.example.demo.entity.GirlEntity;
import com.example.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

//    GET
//    http://localhost:8080/girl/1
//    对应的java代码：

    /**
     * 通过userId获取用户信息
     * @param userId
     * @return
     */
    @GetMapping("/girl/{userId}")
    public List<GirlEntity> queryUserInfo(@PathVariable(name = "userId") Long userId) {
        return girlService.queryUserInfo(userId);
    }

    /**
     * 查询全部
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/girls")
    public Object listAll(@RequestParam(value = "page",defaultValue = "1")int page,
                          @RequestParam(value = "size",defaultValue = "10")int size){
        return girlService.queryAllUserInfo(page, size);
    }

    /**
     * 添加数据
     * @param girl
     * @return
     */
    @RequestMapping("/add")
    public int insert (GirlEntity girl){
        String md5Password = DigestUtils.md5DigestAsHex(girl.getPassword().getBytes());
        girl.setPassword(md5Password);
        return girlService.addGirl(girl);
    }

    /**
     * 修改数据
     * @param girl
     * @return
     */
    @RequestMapping("/update")
    public int update (GirlEntity girl){
        return girlService.updateGirl(girl);
    }
}