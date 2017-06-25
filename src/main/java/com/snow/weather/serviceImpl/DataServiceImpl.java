package com.snow.weather.serviceImpl;

import com.snow.weather.persistence.DataDao;
import com.snow.weather.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by ZHOUJIN on 2017/6/25.
 */
@Service
@Transactional
public class DataServiceImpl implements DataService{

    @Autowired
    private DataDao dataDao;


    @Override
    public void saveCity(String cityName) {
        dataDao.saveCity(cityName);
    }

    @Override
    public void saveLife(String cityName) {
        dataDao.saveLife(cityName);
    }

    @Override
    public void saveTemp(String cityName) {
        dataDao.saveTemp(cityName);
    }

    @Override
    public void saveWeather(String cityName) {
        dataDao.saveWeather(cityName);
    }

    @Override
    public void saveWarning(String cityName) {
        dataDao.saveWarning(cityName);
    }
}
