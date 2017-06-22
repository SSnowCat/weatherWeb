package com.snow.weather.persistence;

import com.snow.weather.domain.*;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface DataDao {

    void saveCity(String cityName);

    void saveLife(String cityName);

    void saveTemp(String cityName);

    void saveWeather(String cityName);

    void saveWarning(String cityName);
}