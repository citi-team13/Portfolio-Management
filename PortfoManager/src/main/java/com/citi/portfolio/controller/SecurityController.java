package com.citi.portfolio.controller;

import com.citi.portfolio.common.Result;
import com.citi.portfolio.infra.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("security")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    /**
     * 查询security(返回price)
     */
    @GetMapping("/{security_id}")
    @ResponseBody
    public Result readSecurity(@PathVariable(value = "security_id") String securityId){

        return securityService.readSecurity(securityId);

    }

    /**
     * 查询security list
     */
    @GetMapping("/securities/{search}/{security_type}/{page}/{pagesize}")
    @ResponseBody
    public Result readSecurityList(@PathVariable(value = "search") String search,
                                   @PathVariable(value = "security_type") String security_type,
                                   @PathVariable(value = "page") int page,
                                   @PathVariable(value = "pagesize") int pageSize){
        return securityService.readSecurityList(search, security_type, page, pageSize);
    }
}
