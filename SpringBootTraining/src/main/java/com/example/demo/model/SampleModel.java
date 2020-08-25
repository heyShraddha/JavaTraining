package com.example.demo.model;

public class SampleModel{
    private String name;
    private String iNumber;
    private String DOB;
    private Integer joiningYear;
    private Integer courseDuration;

    public Integer getJoiningYear(){
        return joiningYear;
    }

    public Integer getCourseDuration(){
        return courseDuration;
    }

    public String getDOB(){
        return DOB;
    }

    public String getName(){
        return name;
    }

    public String getiNumber(){
        return iNumber;
    }

    public void setName(String name){ this.name = name;}

    public void setiNumber(String iNumber){ this.iNumber = iNumber;}

    public void setDOB(String DOB){ this.DOB = DOB;}

    public void setJoiningYear(Integer joiningYear){ this.joiningYear = joiningYear;}

    public void setCourseDuration(Integer courseDuration){ this.courseDuration = courseDuration;}
}
