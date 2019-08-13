package com.citi.portfolio.model;

import java.math.BigDecimal;

public class Price {
    private String securityId;

    private String priceDate;

    private BigDecimal price;

    private Long changeRate;

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }

    public String getPriceDate() {
        return priceDate;
    }

    public void setPriceDate(String priceDate) {
        this.priceDate = priceDate == null ? null : priceDate.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(Long changeRate) {
        this.changeRate = changeRate;
    }
}