package com.snow.weather.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/20.
 */
@Entity
@Table(name="tb_city")
public class City implements Serializable{

    @Id
    private int cityId;//城市id
    private String cunName;//国家名
    private String cityName;//城市名
    private String districtName;//区名

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCunName() {
        return cunName;
    }

    public void setCunName(String cunName) {
        this.cunName = cunName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public City() {
    }

}
