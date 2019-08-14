package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.AdministratorService;
import com.citi.portfolio.mapper.PortfolioMapper;
import com.citi.portfolio.mapper.UserMapper;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.User;
import com.citi.portfolio.util.DateUtil;
import com.citi.portfolio.util.GetData;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PortfolioMapper portfolioMapper;

    @Override
    public Result createAFundManager (User user) {

        //判断Phone是否重复
        User user1 = userMapper.queryUserInfoByUserPhone(user.getPhone());
        if (Assert.isNotNULL(user1)){
            return Result.failure(402,"Phone number is exist!");
        }

        user.setUserId(UUIDUtil.generateShortUuid(User.getID_length()));
        if (userMapper.insertSelective(user) > 0){
            user.setUserPwd("");
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
        List<Map> portfolioDetail  = portfolioMapper.selectPortfolioDetail(userId, DateUtil.getToday());
//        List<Map> portfolioDetail  = portfolioMapper.selectPortfolioDetail(userId, "");
        if(Assert.isNULL(portfolioDetail)){
            return Result.failure(401,"This manager's portfolio information can not access now.");
        }
        return Result.success(portfolioDetail,200,"success!");
    }


    @Override
    public Result getFundManagerList() {
        List<User> userList = userMapper.listAllFundManager();
        if(Assert.isNULL(userList)){
            return Result.failure(401, "Can not get the manager list");
        }
        else{
            for (User user : userList) {
                user.setUserPwd(null);
            }
            return Result.success(userList,200,"success!");
        }

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
        if (userMapper.deleteByPrimaryKey(userId) > 0){
            return Result.success(userId,200,"success!");
        }else {
            return Result.failure(401,"delete fund manager failure!");
        }
    }

    @Override
    public Result transferPortfolio(HttpSession session, String portfolioId, String receiverId){
        if(GetData.checkAuthority(0, session)){
            Portfolio portfolio = portfolioMapper.selectByPrimaryKey(portfolioId);
            portfolio.setManagerId(receiverId);
            if(portfolioMapper.updateByPrimaryKeySelective(portfolio)>0){
                return Result.success(portfolio,200,"success!");
            }else{
                return Result.failure(401,"transfer portfolio failure!");
            }
        }
        else {
            return Result.failure(402,"Transfer portfolio failure for your login status or the authority!");
        }

    }


}
