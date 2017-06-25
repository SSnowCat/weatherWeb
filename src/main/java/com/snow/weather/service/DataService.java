package com.snow.weather.service;

/**
 * Created by ZHOUJIN on 2017/6/25.
 */
public interface DataService {

    void saveCity(String cityName);

    void saveLife(String cityName);

    void saveTemp(String cityName);

    void saveWeather(String cityName);

    void saveWarning(String cityName);
}
