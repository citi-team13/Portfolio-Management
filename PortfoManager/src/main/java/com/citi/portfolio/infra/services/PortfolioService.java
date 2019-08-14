package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;

import javax.servlet.http.HttpSession;

public interface PortfolioService {
    Result addAPortfolio(HttpSession session, String portfolioName);

    Result getAPortfolio(String portfolioId);

    Result getPortfolioList(HttpSession session);
}