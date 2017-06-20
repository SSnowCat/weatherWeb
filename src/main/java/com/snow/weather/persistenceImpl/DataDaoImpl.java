package com.snow.weather.persistenceImpl;

import com.snow.weather.domain.*;
import com.snow.weather.persistence.DataDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/6/20.
 */

public class DataDaoImpl implements DataDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCity() {

    }

    @Override
    public void saveLife() {

    }

    @Override
    public void saveTemp() {

    }

    @Override
    public void saveWeather() {

    }

    @Override
    public void saveWarning() {

    }
}
