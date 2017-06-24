package com.snow.weather.vo;

import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;

/**
 * Created by Administrator on 2017/6/22.
 */
public class WeatherDetailsVO {
    private String condition;//天气状况
    private String conIcon;//天气状况图标
    private int aqiLevel;//空气质量等级
    private String aqiStr;//空气质量描述
    private String aqiIcon;//aqi图标
    private int humidity;//湿度
    private int temp;//温度
    private String tips;//天气小贴士
    private String updatetime;//发布时间
    private String windDir;//风向
    private int windLevel;//风力等级
    private String carLimit;//限行数据

    public WeatherDetailsVO(Weather weather, Temp temp){
        this.condition=weather.getConditionDay();
        this.conIcon=weather.getConditionIdDay().toString();
        this.aqiLevel=1;
        this.aqiStr="23 优";
        this.aqiIcon="2";
        this.humidity=72;
        this.temp=temp.getTemp();
        this.tips="无";
        this.updatetime="今日15：00更新";
        this.windDir="西北风";
        this.windLevel=3;
        this.carLimit="今日限号2和7";
    }

    public WeatherDetailsVO(){}

    public String getCondition() {
        return condition;
    }

    public String getConIcon() {
        return conIcon;
    }

    public int getAqiLevel() {
        return aqiLevel;
    }

    public String getAqiStr() {
        return aqiStr;
    }

    public String getAqiIcon() {
        return aqiIcon;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTemp() {
        return temp;
    }

    public String getTips() {
        return tips;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public String getWindDir() {
        return windDir;
    }

    public int getWindLevel() {
        return windLevel;
    }

    public String getCarLimit() {
        return carLimit;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setConIcon(String conIcon) {
        this.conIcon = conIcon;
    }

    public void setAqiLevel(int aqiLevel) {
        this.aqiLevel = aqiLevel;
    }

    public void setAqiStr(String aqiStr) {
        this.aqiStr = aqiStr;
    }

    public void setAqiIcon(String aqiIcon) {
        this.aqiIcon = aqiIcon;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public void setWindLevel(int windLevel) {
        this.windLevel = windLevel;
    }

    public void setCarLimit(String carLimit) {
        this.carLimit = carLimit;
    }
}
