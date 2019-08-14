package com.citi.portfolio.mapper;

import com.citi.portfolio.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserInfoByUserPhone(String phone);

    List<User> listAllFundManager();
}