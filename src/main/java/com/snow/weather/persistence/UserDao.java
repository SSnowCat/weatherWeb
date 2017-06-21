package com.snow.weather.persistence;

import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public interface UserDao {
    City getCity(String cityName);
    List<Life> getLife(String cityName);
    List<Temp> getTemp(String cityName);
    List<Weather> getWeather(String cityName);
}
