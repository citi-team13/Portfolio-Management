package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.AdministratorService;
import com.citi.portfolio.mapper.UserMapper;
import com.citi.portfolio.model.User;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result createAFundManager (User user) {

        //判断Phone是否重复
        User user1 = userMapper.queryUserInfoByUserPhone(user.getPhone());
        if (Assert.isNotNULL(user1)){
            return Result.failure(402,"Phone number is exist!");
        }

        user.setUserId(UUIDUtil.generateShortUuid(User.getID_length()));
        if (userMapper.insertSelective(user) > 0){
            return Result.success(user,200,"success!");
        }else {
            return Result.failure(401,"Create fund manager failure!");
        }
    }

    @Override
    public Result getFundManager(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        // 如果没有这个用户
        if (Assert.isNULL(user)) {
            return Result.failure(402,"The Fund manager is not exist!");
        }
        return Result.success(user,200,"success!");
    }

    @Override
    public Result getFundManagerDetail(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        // 如果没有这个用户
        if (Assert.isNULL(user)) {
            return Result.failure(402,"The Fund manager is not exist!");
        }
        return Result.success(user,200,"success!");
    }


    @Override
    public Result getFundManagerList() {
        List<User> userList = userMapper.listAllFundManager();
        return Result.success(userList,200,"success!");
    }

    @Override
    public Result updateFundManager(User user) {

        if (userMapper.updateByPrimaryKey(user) > 0){
            return Result.success(user,200,"success!");
        }else {
            return Result.failure(401,"update fund manager failure!");
        }
    }

    @Override
    public Result deleteFundManager(String userId) {
        if (userMapper.deleteByPrimaryKey(userId)>0){
            return Result.success(userId,200,"success!");
        }else {
            return Result.failure(401,"delete fund manager failure!");
        }
    }
}
