package com.snow.weather.service;

/**
 * Created by Administrator on 2017/6/21.
 */

import  com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;

import java.util.List;

public interface CityService {


    List<Temp> getTemp(String cityName);

    List<Weather> getTwoWeeksWeather(String cityName);//获取两周天气

    List<Life> getLifeIndex(String cityName);//获取生活指数
}
