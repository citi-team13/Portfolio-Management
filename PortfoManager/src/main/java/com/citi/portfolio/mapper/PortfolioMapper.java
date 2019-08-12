package com.citi.portfolio.mapper;

import com.citi.portfolio.model.Portfolio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioMapper {
    int deleteByPrimaryKey(String portfolioId);

    int insert(Portfolio record);

    Portfolio selectByPrimaryKey(String portfolioId);

    List<Portfolio> selectAll();

    int updateByPrimaryKey(Portfolio record);
}