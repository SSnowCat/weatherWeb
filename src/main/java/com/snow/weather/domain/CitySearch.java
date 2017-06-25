package com.snow.weather.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/25.
 */
public class CitySearch implements Serializable {
    private String counname;
    private String localName;
    private String pname;
    private String localCounname;
    private String name;
    private String cityId;
    private String id;
    private String city_lable;
    private String localPname;

    public CitySearch() {
    }

    public CitySearch(String counname, String localName, String pname, String localCounname, String name, String cityId, String id, String city_lable, String localPname) {
        this.counname = counname;
        this.localName = localName;
        this.pname = pname;
        this.localCounname = localCounname;
        this.name = name;
        this.cityId = cityId;
        this.id = id;
        this.city_lable = city_lable;
        this.localPname = localPname;
    }

    public String getCounname() {
        return counname;
    }

    public void setCounname(String counname) {
        this.counname = counname;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getLocalCounname() {
        return localCounname;
    }

    public void setLocalCounname(String localCounname) {
        this.localCounname = localCounname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity_lable() {
        return city_lable;
    }

    public void setCity_lable(String city_lable) {
        this.city_lable = city_lable;
    }

    public String getLocalPname() {
        return localPname;
    }

    public void setLocalPname(String localPname) {
        this.localPname = localPname;
    }

    @Override
    public String toString() {
        return "CitySearch{" +
                "counname='" + counname + '\'' +
                ", localName='" + localName + '\'' +
                ", pname='" + pname + '\'' +
                ", localCounname='" + localCounname + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                ", id='" + id + '\'' +
                ", city_lable='" + city_lable + '\'' +
                ", localPname='" + localPname + '\'' +
                '}';
    }
}
