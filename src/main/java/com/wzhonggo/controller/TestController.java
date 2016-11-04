package com.wzhonggo.controller;

import com.alibaba.fastjson.JSON;
import com.wzhonggo.dao.UserDao;
import com.wzhonggo.domain.User;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wzhonggo on 11/3/2016.
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserDao  userDao;

    @RequestMapping(value = "/user/add")
    private void add(HttpServletRequest request,
                           HttpServletResponse response, Long id) {
        User user = new User();
        user.setEmail("wzhonggo@gmail.com");
        user.setScreenName("wzhonggo_" +id);
        userDao.save(user);
    }

    @RequestMapping(value = "/user/delete")
    private void delete(HttpServletRequest request,
                         HttpServletResponse response, Long id) {
        userDao.delete(id);
    }


    @RequestMapping(value = "/user/update")
    private void update(HttpServletRequest request,
                        HttpServletResponse response, Long id) {
        User user = userDao.findOne(id);
        user.setScreenName("wzhonggo__________" +RandomUtils.nextInt(1,10000));
        userDao.save(user);
//        userDao.saveAndFlush(user);
    }


    @RequestMapping(value = "/user/find")
    @ResponseBody
    private String find(HttpServletRequest request,
                         HttpServletResponse response, String email) {
        List<User> userList = userDao.findByEmail(email);
        return JSON.toJSONString(userList);

    }

    @RequestMapping(value = "/user/get")
    @ResponseBody
    private String get(HttpServletRequest request,
                        HttpServletResponse response, Long id) {
        User user = userDao.findOne(id);
        return JSON.toJSONString(user);

    }

    @RequestMapping(value = "/time")
    @ResponseBody
    private String get(HttpServletRequest request,
                       HttpServletResponse response) {
//        SimpleDateFormat sdf =new SimpleDateFormat()
        return new Date().toString();

    }
}
