package com.snow.weather.vo;

import com.snow.weather.domain.Weather;

/**
 * Created by 李德阳 on 2017/6/22.
 */
public class WeatherBriefVO {
    private String conditionDay;//白天天气状况
    private String conditionNight;//晚上天气状况
    private String predictDay;//预报时间
    private String predictDate;//预报日期
    private String predictWeek;//预报星期
    private int tempDay;//白天温度
    private int tempNight;//晚上温度
    private int aqiLevel;//空气质量等级
    private String aqiStr;//空气质量描述
    private String aqiIcon;//aqi图标
    private String windDir;//风向
    private int windLevel;//风力等级
    private String conIconDay;//白天天气状况图标
    private String conIconNight;//晚上天气状况图标
    private String updatetime;//发布时间


    public WeatherBriefVO(Weather weather){

        this.conditionDay=weather.getConditionDay();
        this.conditionNight=weather.getConditionDay();
        this.predictDay="今天";
        this.predictDate=weather.getDay().toString();
        this.predictWeek="星期日";
        this.tempDay=weather.getTempDay();
        this.tempNight=weather.getTempNight();
        this.aqiLevel=2;
        this.aqiStr="72 良";
        this.aqiIcon="2";
        this.windDir="西北";
        this.windLevel=3;
        this.conIconDay=weather.getConditionIdDay().toString();
        this.conIconNight=weather.getConditionDay().toString();
        this.updatetime="今日15：00更新";
    }

    public String getPredictDay() {
        return predictDay;
    }

    public void setPredictDay(String predictDay) {
        this.predictDay = predictDay;
    }
    public WeatherBriefVO(){}

    public String getConditionDay() {
        return conditionDay;
    }

    public String getConditionNight() {
        return conditionNight;
    }

    public String getPredictDate() {
        return predictDate;
    }

    public String getPredictWeek() {
        return predictWeek;
    }

    public int getTempDay() {
        return tempDay;
    }

    public int getTempNight() {
        return tempNight;
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

    public String getWindDir() {
        return windDir;
    }

    public int getWindLevel() {
        return windLevel;
    }

    public String getConIconDay() {
        return conIconDay;
    }

    public String getConIconNight() {
        return conIconNight;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setConditionDay(String conditionDay) {
        this.conditionDay = conditionDay;
    }

    public void setConditionNight(String conditionNight) {
        this.conditionNight = conditionNight;
    }

    public void setPredictDate(String predictDate) {
        this.predictDate = predictDate;
    }

    public void setPredictWeek(String predictWeek) {
        this.predictWeek = predictWeek;
    }

    public void setTempDay(int tempDay) {
        this.tempDay = tempDay;
    }

    public void setTempNight(int tempNight) {
        this.tempNight = tempNight;
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

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public void setWindLevel(int windLevel) {
        this.windLevel = windLevel;
    }

    public void setConIconDay(String conIconDay) {
        this.conIconDay = conIconDay;
    }

    public void setConIconNight(String conIconNight) {
        this.conIconNight = conIconNight;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
