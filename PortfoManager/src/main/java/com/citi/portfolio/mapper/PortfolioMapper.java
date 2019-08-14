package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioDetails;
import java.util.List;
import java.util.Map;

import com.citi.portfolio.model.PortfolioPriceDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PortfolioMapper {

    int deleteByPrimaryKey(String portfolioId);

    int insert(Portfolio record);

    int insertSelective(Portfolio record);

    Portfolio selectByPrimaryKey(String portfolioId);

    int updateByPrimaryKeySelective(Portfolio record);

    int updateByPrimaryKey(Portfolio record);

    Portfolio selectByPortfolioName(String portfolioName);

    List<Portfolio> selectAllForCurrentUser(String userId);

    List<Map> selectPortfolioDetail(String portfolioId, String currentDate);

    List<Map> getAllPrice(String portfolioId);

    List<Map> getRecentPrice(String portfolioId, String lastDate);
}