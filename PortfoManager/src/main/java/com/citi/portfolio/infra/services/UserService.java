package com.citi.portfolio.infra.services;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.model.User;
import javax.servlet.http.HttpSession;

public interface UserService {

    Result userLogin(User user , HttpSession session);

    Result getCurrentUser(HttpSession session);

//
//    Result getFundUserDetail(String userId);
//
//    Result getFundUserList();
//
//    Result updateFundUser(User user);
//
//    Result deleteFundUser(String userId);

}
