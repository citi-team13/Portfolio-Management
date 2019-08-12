package com.citi.portfolio.controller;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.AdministratorService;
import com.citi.portfolio.infra.services.SecurityService;
import com.citi.portfolio.infra.services.UserService;
import com.citi.portfolio.model.Security;
import com.citi.portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

//    @Autowired
//    private PriceService priceService;
//
    @Autowired
    private SecurityService securityService;

    @PostMapping("/fundmanager")
    @ResponseBody
    public Result createFundUser(User user){
        return administratorService.createAFundManager(user);
    }

    /**
     * 获取基金经理用户详情
     */
    @GetMapping("/fundmanager")
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
    @DeleteMapping("/funduser")
    @ResponseBody
    public Result deleteFundUser(String userId){
        return administratorService.deleteFundManager(userId);
    }
//
//    //todo 接口用户portfolio转移
//
//
//
//    /**
//     * price只有创建 并且只对当天日期的price进行修改
//     */
//
//    /**
//     * 创建价格
//     */
//    @PostMapping("/price")
//    @ResponseBody
//    public Result createPrice(Price price){
//
//        return priceService.createPrice(price);
//    }
//
//    /**
//     * 修改价格 只修改当前系统时间的
//     */
//    @PostMapping("/price/{price_id}")
//    @ResponseBody
//    public Result updatePrice(@PathVariable(value = "price_id") String priceId,Price price){
//        price.setPriceId(priceId);
//        return priceService.updatePrice(price);
//    }
//
//
    /**
     * 创建security
     */
    @PostMapping("/security")
    @ResponseBody
    public Result createSecurity(Security securityInfo){
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
    @GetMapping("/security")
    @ResponseBody
    public Result readSecurityList(@RequestParam(value = "search",required = false) String search,
                                   @RequestParam(value = "page",required = false) int page,
                                   @RequestParam(value = "securityType",required = false) String securityType){

        return securityService.readSecurityList(search,securityType,page);
    }



}
