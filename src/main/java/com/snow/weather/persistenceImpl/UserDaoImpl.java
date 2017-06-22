package com.snow.weather.persistenceImpl;

import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.persistence.UserDao;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public class UserDaoImpl implements UserDao{
    @Override
    public City getCity(String cityName) {
        return null;
    }

    @Override
    public List<Life> getLife(String cityName) {
        return null;
    }

    @Override
    public List<Temp> getTemp(String cityName) {
        return null;
    }

    @Override
    public List<Weather> getWeather(String cityName) {
        return null;
    }
}
