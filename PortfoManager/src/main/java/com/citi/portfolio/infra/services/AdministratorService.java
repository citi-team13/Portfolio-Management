package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface AdministratorService {

    Result createAFundManager(User Record);

    Result getFundManager(String userId);

    Result getFundManagerDetail(String userId);

    Result getFundManagerList();

    Result updateFundManager(User user);

    Result deleteFundManager(String userId);


}
