package com.snow.weather.persistence;

import com.snow.weather.domain.*;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface DataDao {

    void saveCity();

    void saveLife();

    void saveTemp();

    void saveWeather();

    void saveWarning();
}