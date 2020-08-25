package com.example.demo.model;

public class MinimisedModel {
    private String iNumber;
    private String name;
    private String batch;

    public String getiNumber(){ return iNumber;}

    public String getName(){ return  name;}

    public String getBatch(){
        return batch;
    }

    public void setiNumber(String iNumber){
        this.iNumber = iNumber;
    }

    public void setName(String name){ this.name = name;}

    public void setBatch(String batch){ this.batch = batch;}
}
