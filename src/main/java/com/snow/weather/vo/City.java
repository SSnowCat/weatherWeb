package com.snow.weather.vo;

/**
 * Created by 李德阳 on 2017/6/22.
 */
public class City {
    private String counname;
    private String pname;
    private String name;

    public void setCounname(String counname) {
        this.counname = counname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounname() {

        return counname;
    }

    public String getPname() {
        return pname;
    }

    public String getName() {
        return name;
    }
}
