package com.fmtech.rxjavaretrofit.model;

/**
 * ==================================================================
 * Copyright (C) 2016 FMTech All Rights Reserved.
 *
 * @author Drew.Chiang
 * @version v1.0.0
 * @email chiangchuna@gmail.com
 * @create_date 2016/7/6 21:00
 * @description ${todo}
 * <p/>
 * ==================================================================
 */

public class FakeToken {

    public String token;
    public boolean expired;

    public FakeToken(){

    }

    public FakeToken(boolean expired){
        this.expired = expired;
    }

}
