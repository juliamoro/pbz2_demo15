package com.company.controller;

import java.util.regex.*;

public class Phone implements Validator{

    public static final String REG_Belarus_Phone = "(\\+375)(29|33|25|44)(\\d{7})";

    public  Phone(){
    }

    @Override
    public boolean validator(String phone) {
        Pattern pattern = Pattern.compile(REG_Belarus_Phone);
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }
}
