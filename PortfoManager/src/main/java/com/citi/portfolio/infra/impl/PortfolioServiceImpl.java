package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Assert;
import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PortfolioService;
import com.citi.portfolio.mapper.PortfolioMapper;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioDetails;
import com.citi.portfolio.model.PortfolioPriceDetail;
import com.citi.portfolio.util.DateUtil;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    PortfolioMapper portfolioMapper;

    @Override
    public Result addAPortfolio(HttpSession session, String portfolioName) {
        // 判断portfolioName是否重复
        Portfolio portfolio = portfolioMapper.selectByPortfolioName(portfolioName);
        if (Assert.isNotNULL(portfolio)){
            return Result.failure(402,"portfolioName is exist!");
        }
        portfolio.setPortfolioId(UUIDUtil.generateShortUuid(8));
        portfolio.setPortfolioName(portfolioName);
        portfolio.setManagerId(session.getAttribute("userId").toString());
        portfolio.setCreateDate(DateUtil.getToday());
        if (portfolioMapper.insertSelective(portfolio) > 0){
            return Result.success(portfolio,200,"success!");
        }else {
            return Result.failure(401,"Create fund manager failure!");
        }
    }

    @Override
    public Result getAPortfolio(String portfolioId) {
        String currentDate = DateUtil.getToday();
        List<PortfolioDetails> ps = portfolioMapper.selectPortfolioDetail(portfolioId, currentDate);
        return Result.success(ps,200,"success!");
    }

    @Override
    public Result getPortfolioList(HttpSession session) {
        String userId = session.getAttribute("userId").toString();
        List<Portfolio> portfolioList = portfolioMapper.selectAllForCurrentUser(userId);
        return Result.success(portfolioList,200,"success!");
    }

    @Override
    public Result getAllPrice(String portfolioId) {
        List<Map> priceList = portfolioMapper.getAllPrice(portfolioId);
        return Result.success(priceList,200,"success!");
    }

    @Override
    public Result getRecentPrice(String portfolioId, String lastDate) {
        List<PortfolioPriceDetail> priceList = portfolioMapper.getRecentPrice(portfolioId, lastDate);
        return Result.success(priceList,200,"success!");
    }
}