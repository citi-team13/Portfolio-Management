package com.citi.portfolio.util;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.mapper.UserMapper;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class GetData {

    @Autowired
    private static UserMapper userMapper;

    public static User getCurrentUser(HttpSession session){
        User user = null;
        if(Assert.isNULL(session.getAttribute("userId"))){
            return null;
        }
        else{
            String userid = session.getAttribute("userId").toString();
            user = userMapper.selectByPrimaryKey(userid);
            // 如果没有这个用户
            if (Assert.isNULL(user)) {
                return null;
            }else{
                return user;
            }
        }
    }

    public static boolean checkAuthority(int role, HttpSession session){
        User temp = getCurrentUser(session);
        if (Assert.isNULL(temp)) {
            return false;
        }else{
            if(temp.getUserType() == role){
                return true;
            }else{
                return false;
            }
        }
    }
}
