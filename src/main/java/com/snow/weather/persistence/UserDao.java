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
    List<Life> getLife(City city);
    List<Temp> getTemp(City city);
    List<Weather> getWeather(City city);
    boolean searchCity(String cityName);
}
