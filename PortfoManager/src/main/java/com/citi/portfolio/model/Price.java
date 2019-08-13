package com.citi.portfolio.model;

import java.math.BigDecimal;

public class Price {
    private String securityId;

    private String valueDate;

    private BigDecimal value;

    private Double priceChangeRate;

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate == null ? null : valueDate.trim();
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Double getPriceChangeRate() {
        return priceChangeRate;
    }

    public void setPriceChangeRate(Double priceChangeRate) {
        this.priceChangeRate = priceChangeRate;
    }
}