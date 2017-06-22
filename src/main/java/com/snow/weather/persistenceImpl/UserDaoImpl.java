package com.snow.weather.persistenceImpl;

import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.persistence.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Life> getLife(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Life as c where c.city.cityId=?",Life.class)
                .setParameter(0, city.getCityId())
                .getResultList();
    }

    @Override
    public List<Temp> getTemp(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Temp as c where c.city.cityId=?",Temp.class)
                .setParameter(0,city.getCityId())
                .getResultList();

    }

    @Override
    public List<Weather> getWeather(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Weather as c where c.city.cityId=?",Weather.class)
                .setParameter(0,city.getCityId())
                .getResultList();
    }

    @Override
    public City getCity(String cityName) {
//        return sessionFactory.getCurrentSession().get(City.class,cityid);
            return  sessionFactory.getCurrentSession()
                    .createQuery("from City as o where o.cityName=?",City.class)
                    .setParameter(0,cityName)
                    .getSingleResult();
    }


}
