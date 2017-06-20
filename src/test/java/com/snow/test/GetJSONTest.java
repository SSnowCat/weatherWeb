package com.snow.test;

import com.snow.weather.util.GetJSON;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/20.
 */
public class GetJSONTest {
    private static final String LAT = "39.91488908";
    private static final String LON = "116.40387397";

    @Test
    public void testGetLifeJson(){
        String life = GetJSON.getLifeJson(LAT, LON);
        Assert.assertNotEquals(-1,life.indexOf("\"msg\":\"success\""));
    }

    @Test
    public void testGetTempJson(){
        String temp = GetJSON.getTempJson(LAT, LON);
        Assert.assertNotEquals(-1,temp.indexOf("\"msg\":\"success\""));
    }

    @Test
    public void testGetWarningJson(){
        String wanging  = GetJSON.getWarningJson(LAT, LON);
        Assert.assertNotEquals(-1,wanging.indexOf("\"msg\":\"success\""));
    }

    @Test
    public void testGetWeatherJson(){
        String weather = GetJSON.getWeatherJson(LAT, LON);
        Assert.assertNotEquals(-1,weather.indexOf("\"msg\":\"success\""));
    }
}
