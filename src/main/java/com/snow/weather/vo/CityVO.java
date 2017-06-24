package com.snow.weather.vo;

import com.snow.weather.domain.City;

/**
 * Created by 李德阳 on 2017/6/22.
 */
public class CityVO {
    private String counname;
    private String pname;
    private String name;

    public CityVO() {
    }

    public CityVO(City city){
        this.counname=city.getCunName();
        this.pname=city.getCityName();
        this.name=city.getDistrictName();
    }

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
