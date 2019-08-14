package com.citi.portfolio.controller;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.AdministratorService;
import com.citi.portfolio.infra.services.PriceService;
import com.citi.portfolio.infra.services.SecurityService;
import com.citi.portfolio.model.Price;
import com.citi.portfolio.model.Security;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/fundmanagers")
    @ResponseBody
    public Result createFundUser(@RequestBody User user){
        return administratorService.createAFundManager(user);
    }

    /**
     * 获取基金经理用户详情
     */
    @GetMapping("/fundmanager/{userId}")
    @ResponseBody
    public Result getFundUser(@PathVariable(value = "userId") String userId){
        return administratorService.getFundManager(userId);
    }

    /**
     * 获取基金经理用户列表
     */
    @GetMapping("/fundmanagers")
    @ResponseBody
    public Result getFundUserList(){
        return administratorService.getFundManagerList();
    }

    /**
     * 修改用户信息
     */
    @PostMapping("/funduser/{user_id}")
    @ResponseBody
    public Result updateFundUser(@PathVariable(value = "user_id") String userId,User user){
        user.setUserId(userId);
        return administratorService.updateFundManager(user);
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping("/funduser/{userId} ")
    @ResponseBody
    public Result deleteFundUser(String userId){
        return administratorService.deleteFundManager(userId);
    }

//    //todo 接口用户portfolio转移

    /**
     * price只有创建当天日期的price
     */

    /**
     * 创建价格
     */
    @PostMapping("/price")
    @ResponseBody
    public Result createPrice(@RequestBody Price price){
        return priceService.createPrice(price);
    }

    /**
     * 修改价格
     */
    @PostMapping("/price/{security_id}/{value_date}")
    @ResponseBody
    public Result updatePrice(@PathVariable(value = "security_id") String priceId, @PathVariable(value = "value_date") String valueDate,Price price){
        return priceService.updatePrice(price);
    }


    /**
     * 创建security
     */
    @PostMapping("/securities")
    @ResponseBody
    public Result createSecurity(@RequestBody Security securityInfo){
        return securityService.createSecurity(securityInfo);
    }

    /**
     * 查询security(返回price)
     */
    @GetMapping("/security/{security_id}")
    @ResponseBody
    public Result readSecurity(@PathVariable(value = "security_id") String securityId,@RequestParam(value = "page",required = false) int page){
        return securityService.readSecurity(securityId);
    }

    /**
     * 查询security list
     */
    @GetMapping("/securities")
    @ResponseBody
    public Result readSecurityList(@RequestParam(value = "search",required = false) String search,
                                   @RequestParam(value = "page",required = false) int page,
                                   @RequestParam(value = "securityType",required = false) String securityType,
                                   @RequestParam(value = "pagesize",required = false) int pageSize){

        return securityService.readSecurityList(search,securityType,page,pageSize);
    }

    @PostMapping("/security")
    @ResponseBody
    public Result updateSecurity(@RequestBody Security securityInfo){
        return securityService.updateSecurity(securityInfo);
    }

    @DeleteMapping("/security/{security_id}")
    @ResponseBody
    public Result deleteSecurity(@PathVariable(value = "security_id") String security_id){
        return administratorService.deleteFundManager(security_id);
    }

    /**
     * 转移
     */
    @PostMapping("/funduser/{targetId, portfolioId}")
    @ResponseBody
    public Result transferPortfolio(HttpSession session,
                                    @RequestParam(value = "targetId") String target_id,
                                    @RequestParam(value = "portfolioId") String portfolio_id){

        return administratorService.transferPortfolio(session, target_id,portfolio_id);
    }





}
