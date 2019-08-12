package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.model.PortfolioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PortfolioMapper {
    int countByExample(PortfolioExample example);

    int deleteByExample(PortfolioExample example);

    int deleteByPrimaryKey(String portfolioId);

    int insert(Portfolio record);

    int insertSelective(Portfolio record);

    List<Portfolio> selectByExample(PortfolioExample example);

    Portfolio selectByPrimaryKey(String portfolioId);

    int updateByExampleSelective(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    int updateByExample(@Param("record") Portfolio record, @Param("example") PortfolioExample example);

    int updateByPrimaryKeySelective(Portfolio record);

    int updateByPrimaryKey(Portfolio record);
}