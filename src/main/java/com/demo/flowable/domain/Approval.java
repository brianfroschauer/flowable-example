package com.demo.flowable.domain;

/**
 * Author: brianfroschauer
 * Date: 03/12/2019
 */
public class Approval {

    private String id;
    private boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
