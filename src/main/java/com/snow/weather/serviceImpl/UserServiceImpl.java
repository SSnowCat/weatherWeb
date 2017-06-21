package com.snow.weather.serviceImpl;

import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.service.CityService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public class CityServiceImpl implements CityService{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Temp> getTemp(String cityName) {
        
        return null;
    }

    @Override
    public List<Weather> getTwoWeeksWeather(String cityName) {
        return null;
    }

    @Override
    public List<Life> getLifeIndex(String cityName) {
        return null;
    }
}
