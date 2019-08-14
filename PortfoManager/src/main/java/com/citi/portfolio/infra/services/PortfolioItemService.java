package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;

public interface PortfolioItemService {
    Result addAPortfolioItem(String portfolioId, String securityId, String positionValue);
}
