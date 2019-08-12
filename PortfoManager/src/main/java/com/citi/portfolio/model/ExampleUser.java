package com.citi.portfolio.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExampleUser implements Serializable {

    private String userCode;

    private String userName;

    private String password;
}
