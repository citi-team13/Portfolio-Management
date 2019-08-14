package com.citi.portfolio.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {
    private String securityId;

    private String valueDate;

    private BigDecimal value;

    private static final long serialVersionUID = 1L;

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
}