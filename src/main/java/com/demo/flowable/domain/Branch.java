package com.demo.flowable.domain;

/**
 * Author: brianfroschauer
 * Date: 09/12/2019
 */
public class Branch {

    private String id;
    private String name;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
