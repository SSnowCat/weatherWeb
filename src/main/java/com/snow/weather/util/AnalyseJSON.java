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
        city.setCityName((String) jsonObject.get("pname"));
        city.setCunName((String)jsonObject.get("counname"));
        city.setDistrictName((String)jsonObject.get("name"));
        return city;
    }

    public static List<Life> getLife(String lifeJson){
        List list = new ArrayList();
        JSONObject jsonObject = JSONObject.parseObject(lifeJson)
                .getJSONObject("data")
                .getJSONObject("liveIndex");
        JSONArray jsonArray = jsonObject.getJSONArray(getFormatDate());

        for(int i = 0; i < 8; i++){
            Life life = new Life();
            life.setDay(new Date());
            life.setDesc(jsonArray.getJSONObject(i).getString("desc"));
            life.setDesc(jsonArray.getJSONObject(i).getString("name"));
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
                .getJSONObject("data")
                .getJSONObject("hourly");
        for(int i = 0; i < 26; i++){
            Temp temp = new Temp();
            temp.setDate(new Date());
            temp.setCity(getCity(tempJson));
            temp.setHour(Integer.parseInt((String)jsonObject.getJSONObject(String.valueOf(i)).get("hour")));
            temp.setTemp(Integer.parseInt((String)jsonObject.getJSONObject(String.valueOf(i)).get("temp")));
            list.add(temp);
        }
        return list;
    }

    public static List<Weather> getWeather(String weatherJson) throws ParseException{
        List list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parseObject(weatherJson)
                .getJSONObject("data")
                .getJSONObject("forcast");
        for(int i = 0; i < 16 ; i ++){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            Date day = sdf.parse((String ) jsonObject.getJSONObject(String.valueOf(i)).get("predictDay"));
            //Date date = sdf.parse(dateString);
            Weather weather = new Weather();
            weather.setCity(getCity(weatherJson));
            weather.setConditionDay((String) jsonObject.getJSONObject(String.valueOf(i)).get("conditionDay"));
            weather.setDay(day);
            weather.setTempDay(Integer.parseInt((String) jsonObject.getJSONObject(String.valueOf(i)).get("tempDay")));
            weather.setTempNight(Integer.parseInt((String) jsonObject.getJSONObject(String.valueOf(i)).get("tempNight")));
            list.add(weather);
        }
        return list;
    }

}
