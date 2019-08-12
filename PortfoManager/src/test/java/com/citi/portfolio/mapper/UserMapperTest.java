package com.citi.portfolio.mapper;

import com.citi.portfolio.infra.services.UserService;
import com.citi.portfolio.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryUserInfoByUserPhone(){
        User user = new User();
        user.setUserPwd("123456");
        user.setPhone("18840836056");
        user = userMapper.queryUserInfoByUserPhone("18840836056");
        System.out.println(user.getUserName());
    }

}