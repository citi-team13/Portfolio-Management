package com.citi.portfolio.infra.impl;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PortfolioService;
import com.citi.portfolio.mapper.PortfolioMapper;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioDetails;
import com.citi.portfolio.util.GetDate;
import com.citi.portfolio.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    PortfolioMapper portfolioMapper;

    @Override
    public Result addAPortfolio(HttpSession session, String portfolioName) {
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioId(UUIDUtil.generateShortUuid(8));
        portfolio.setPortfolioName(portfolioName);
        portfolio.setManagerId(session.getAttribute("userId").toString());
        portfolio.setCreateDate(GetDate.getCurrentDate());
        return Result.success(portfolio,200,"success!");
    }

    @Override
    public Result getAPortfolio(String portfolioId) {
        List<PortfolioDetails> ps = portfolioMapper.selectPortfolioDetail(portfolioId);
        return Result.success(ps,200,"success!");
    }

    @Override
    public Result getPortfolioList(HttpSession session) {
        String userId = session.getAttribute("userId").toString();
        List<Portfolio> portfolioList = portfolioMapper.selectAllForCurrentUser(userId);
        return Result.success(portfolioList,200,"success!");
    }
}