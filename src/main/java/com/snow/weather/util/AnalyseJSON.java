package com.snow.weather.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.snow.weather.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public final class AnalyseJSON {

    public static String getFormatDate(){
        String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return formatDate;
    }

    public static City getCity(String json){
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(json)
                .getJSONObject("data")
                .getJSONObject("city");
        City city = new City();
        city.setCityId(Integer.parseInt(String.valueOf(jsonObject.get("cityId"))));
        city.setCityName((String) jsonObject.get("pname"));
        city.setCunName((String)jsonObject.get("counname"));
        city.setDistrictName((String)jsonObject.get("name"));
        return city;
    }

    public static List<Life> getLife(String lifeJson){
        List list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(lifeJson)
                .getJSONObject("data")
                .getJSONObject("liveIndex");
        JSONArray jsonArray = jsonObject.getJSONArray(getFormatDate());
        for(int i = 0; i < 8; i++){
            Life life = new Life();
            life.setDay(new Date());
            life.setDesc(jsonArray.getJSONObject(i).getString("desc"));
            life.setName(jsonArray.getJSONObject(i).getString("name"));
            life.setStatus(jsonArray.getJSONObject(i).getString("status"));
            life.setCity(getCity(lifeJson));
            list.add(life);
        }
        return list;
    }

    public static Warning getWarning(String warningJson){

        return null;
    }

    public static List<Temp> getTemp(String tempJson){
        List list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(tempJson)
                .getJSONObject("data");
        JSONArray jsonArray = jsonObject.getJSONArray("hourly");
        for(int i = 0; i < 26; i++){
            Temp temp = new Temp();
            temp.setDate(new Date());
            temp.setCity(getCity(tempJson));
            temp.setHour(Integer.parseInt(jsonArray.getJSONObject(i).getString("hour")));
            temp.setTemp(Integer.parseInt(jsonArray.getJSONObject(i).getString("temp")));
            list.add(temp);
        }
        return list;
    }

    public static List<Weather> getWeather(String weatherJson) throws ParseException{
        List list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(weatherJson)
                .getJSONObject("data");
        JSONArray jsonArray = jsonObject.getJSONArray("forecast");
        for(int i = 0; i < 16 ; i ++){

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date day = sdf.parse(jsonArray.getJSONObject(i).getString("predictDate"));


            Weather weather = new Weather();
            weather.setCity(getCity(weatherJson));
            weather.setConditionDay(jsonArray.getJSONObject(i).getString("conditionDay"));
            weather.setDay(day);
            weather.setTempDay(Integer.parseInt(jsonArray.getJSONObject(i).getString("tempDay")));
            weather.setTempNight(Integer.parseInt(jsonArray.getJSONObject(i).getString("tempNight")));
            list.add(weather);
        }
        return list;
    }

}
