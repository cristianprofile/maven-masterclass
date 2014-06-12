package com.mylab.cromero.dto;
/**
* <h1>BaseRequest</h1>
* BaseRequest dto request 
* <p>
* <b>BaseRequest</b> BaseRequest data transfer object 
* for sevice layer
*
* @author  Cristian Romero Matesanz
*
* 
*/
public class BaseRequest {

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
        builder.append("BaseRequest [name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

}
