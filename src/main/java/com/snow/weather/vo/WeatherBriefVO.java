package com.snow.weather.vo;

/**
 * Created by 李德阳 on 2017/6/22.
 */
public class WeatherBriefVO {
    private String conditionDay;//白天天气状况
    private String conditionIdNight;//晚上天气状况
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

    public String getConditionDay() {
        return conditionDay;
    }

    public String getConditionIdNight() {
        return conditionIdNight;
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

    public void setConditionIdNight(String conditionIdNight) {
        this.conditionIdNight = conditionIdNight;
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
