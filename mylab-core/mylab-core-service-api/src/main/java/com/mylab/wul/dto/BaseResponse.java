package com.mylab.wul.dto;

public class BaseResponse {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BaseResponse [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
