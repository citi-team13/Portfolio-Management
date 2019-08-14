package com.citi.portfolio.controller;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.PortfolioItemService;
import com.citi.portfolio.infra.services.PortfolioService;
import com.citi.portfolio.model.Portfolio;
import com.citi.portfolio.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("Manager")
public class ManagerController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioItemService portfolioItemService;

    /**
     * 添加一个新的投资组合
     */
    @PostMapping("/addPortfolio")
    @ResponseBody
    public Result addAPortfolio(HttpSession session, String portfolioName){
        return portfolioService.addAPortfolio(session, portfolioName);
    }

    /**
     * 为投资组合添加Security
     */
    @GetMapping("/addSecurity")
    @ResponseBody
    public Result addASercurity(@PathVariable(value = "portfolio_id")String portfolioId,
                                @PathVariable(value = "security_id")String securityId,
                                @PathVariable(value = "position_value")String positionValue){
        return portfolioItemService.addAPortfolioItem(portfolioId, securityId, positionValue);
    }

    /**
     * 查询某一个投资组合
     */
    @GetMapping("/getPortfolio/{portfolio_id}")
    @ResponseBody
    public Result getAPortfolio(@PathVariable(value = "portfolio_id")String portfolioId){
        return portfolioService.getAPortfolio(portfolioId);
    }

    /**
     * 获取该用户的所有投资组合
     */
    @GetMapping("/getPortfolios")
    @ResponseBody
    public Result getPortfolioList(HttpSession session){
        return portfolioService.getPortfolioList(session);
    }

    /**
     * 查询某个投资组合的历史价格
     */
    @GetMapping("/getAllPortfolioPrice/{portfolio_id}")
    @ResponseBody
    public Result getAllPrice(@PathVariable(value = "portfolio_id")String portfolioId){
        return portfolioService.getAllPrice(portfolioId);
    }

    /**
     * 查询某个投资组合的最近两天的价格
     */
    @GetMapping("/getRecentPortfolioPrice/{portfolio_id}")
    @ResponseBody
    public Result getRecentPrice(@PathVariable(value = "portfolio_id")String portfolioId){
        String lastDate = DateUtil.getYestoday();
        return portfolioService.getRecentPrice(portfolioId, lastDate);
    }
}