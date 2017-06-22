package com.snow.weather.serviceImpl;

import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.persistence.UserDao;
import com.snow.weather.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Temp> getTemp(City city) {

        return userDao.getTemp(city);
    }

    @Override
    public List<Weather> getTwoWeeksWeather(City city) {
        return userDao.getWeather(city);
    }

    @Override
    public List<Life> getLifeIndex(City city) {
        return userDao.getLife(city);
    }
}
