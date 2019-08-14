package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.UserService;
import com.citi.portfolio.mapper.UserMapper;
import com.citi.portfolio.model.User;

import com.citi.portfolio.util.GetData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private Map<String,String> buildUserDataMap(User user) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("UserId", user.getUserId());
        map.put("UserName", user.getUserName());
        map.put("UserType", user.getUserType().toString());
        map.put("Phone", user.getPhone());
        map.put("Email", user.getEmail());
        return map;
    }

    @Override
    public Result userLogin(User user, HttpSession session) {
        String password = user.getUserPwd();
        user = userMapper.queryUserInfoByUserPhone(user.getPhone());
        // 如果没有这个用户
        if (Assert.isNULL(user)) {
            return Result.failure(402,"User's phone number is not exist!");
        }
        // 对比密码
        if (!user.getUserPwd().equals(password)) {
            return Result.failure(401,"User's phone or password is not correct!");
        }else{
            session.setAttribute("userId", user.getUserId());
            Map map = buildUserDataMap(user);
            return Result.success(map,200,"Logon successfully!");
        }
    }
    @Override
    public Result getCurrentUser(HttpSession session) {
        User user = GetData.getCurrentUser(session);
        if (Assert.isNULL(user)) {
            return Result.failure(402,"There is no user login the system!");
        }else{
            Map map = buildUserDataMap(user);
            return Result.success(map,200,"Query current user successfully!");
        }
    }



}
