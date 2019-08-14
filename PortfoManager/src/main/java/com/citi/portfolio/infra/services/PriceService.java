package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.model.Price;
import com.citi.portfolio.model.Security;

public interface PriceService {

    Result createPrice(Price price);

    Result updatePrice(Price price);

    Result readHistoryPrice(String securityId);
}
