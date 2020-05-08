package com.company.Entity;

import java.io.Serializable;

public class Request implements Serializable {
    private String funcName, st1, st2;
    private Object object1;

    public Request(String funcName, String st1, String st2, Object object1) {
        this.funcName = funcName;
        this.st1 = st1;
        this.st2 = st2;
        this.object1 = object1;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getSt1() {
        return st1;
    }

    public void setSt1(String st1) {
        this.st1 = st1;
    }

    public String getSt2() {
        return st2;
    }

    public void setSt2(String st2) {
        this.st2 = st2;
    }

    public Object getObject1() {
        return object1;
    }

    public void setObject1(Object object1) {
        this.object1 = object1;
    }
}
