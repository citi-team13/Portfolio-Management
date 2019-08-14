package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioDetails;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PortfolioMapper {

    int deleteByPrimaryKey(String portfolioId);

    int insert(Portfolio record);

    int insertSelective(Portfolio record);

    Portfolio selectByPrimaryKey(String portfolioId);

    int updateByPrimaryKeySelective(Portfolio record);

    int updateByPrimaryKey(Portfolio record);

    List<Portfolio> selectAllForCurrentUser(String userId);

    List<PortfolioDetails> selectPortfolioDetail(String portfolioid);
}