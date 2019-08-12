package com.citi.portfolio.mapper;

import com.citi.portfolio.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    User selectByPrimaryKey(String userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserInfoByUserPhone(String phone);

    int insertSelective(User record);

    List<User> listAllFundManager();
}