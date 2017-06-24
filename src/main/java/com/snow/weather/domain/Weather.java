package com.snow.weather.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/20.
 */
@Entity
@Table(name = "tb_weather")
public class Weather implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date day;//日期
    private String conditionDay;//天气状况
    private Integer conditionIdDay;
    private int tempDay;//白天温度
    private int tempNight;//夜晚温度
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getConditionDay() {
        return conditionDay;
    }

    public void setConditionDay(String conditionDay) {
        this.conditionDay = conditionDay;
    }

    public Integer getConditionIdDay() {
        return conditionIdDay;
    }

    public void setConditionIdDay(Integer conditionIdDay) {
        this.conditionIdDay = conditionIdDay;
    }

    public int getTempDay() {
        return tempDay;
    }

    public void setTempDay(int tempDay) {
        this.tempDay = tempDay;
    }

    public int getTempNight() {
        return tempNight;
    }

    public void setTempNight(int tempNight) {
        this.tempNight = tempNight;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
