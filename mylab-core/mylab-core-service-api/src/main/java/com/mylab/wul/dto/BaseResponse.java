package com.mylab.wul.dto;
/**
* <h1>BaseResponse</h1>
* BaseRequest dto request 
* <p>
* <b>BaseResponse</b> BaseResponse data transfer object 
* for sevice layer
*
* @author  Cristian Romero Matesanz
*
* 
*/
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
