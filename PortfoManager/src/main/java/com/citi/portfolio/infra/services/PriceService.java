package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.model.Price;

public interface PriceService {

    Result createPrice(Price price);

    Result updatePrice(Price price);
}
