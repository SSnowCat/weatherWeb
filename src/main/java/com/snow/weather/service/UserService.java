package com.snow.weather.service;

/**
 * Created by Administrator on 2017/6/21.
 */

import  com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;

import java.util.List;

public interface UserService {


    List<Temp> getTemp(City city);//获取24小时温度

    List<Weather> getTwoWeeksWeather(City city);//获取两周天气

    List<Life> getLifeIndex(City city);//获取生活指数
}
