package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.model.Security;

public interface SecurityService {
    Result createSecurity(Security Record);

    Result readSecurity(String securityId);

    Result readSecurityList(String search, String securityType, int page);

    Result updateSecurity(Security Record);

    Result deleteSecurity(String securityId);
}
