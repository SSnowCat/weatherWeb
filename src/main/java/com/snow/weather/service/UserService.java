package com.snow.weather.service;

/**
 * Created by Administrator on 2017/6/21.
 */

import  com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.vo.WeatherDetails;

import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.List;

public interface UserService {


    WeatherDetails getWeatherDetails(City city);//天气实况
    List<Temp> getTemp(City city);//获取24小时温度

    List<Weather> getTwoWeeksWeather(City city);//获取两周天气

    List<Life> getLifeIndex(City city);//获取生活指数

    Weather getCurrentWeather(City city);

    Temp getCurrentTemp(City city);

}
