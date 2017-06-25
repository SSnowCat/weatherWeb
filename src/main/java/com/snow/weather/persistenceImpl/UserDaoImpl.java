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

    /**
     * 通过城市获取生活指数
     * @param city
     * @return 生活指数的结果集
     */
    @Override
    public List<Life> getLife(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Life as c where c.city.cityId=?",Life.class)
                .setParameter(0, city.getCityId())
                .getResultList();
    }

    /**
     * 通过城市获取24小时温度
     * @param city
     * @return 温度结果集
     */
    @Override
    public List<Temp> getTemp(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Temp as c where c.city.cityId=?",Temp.class)
                .setParameter(0,city.getCityId())
                .getResultList();

    }

    /**
     * 通过城市获取15天天气状况
     * @param city
     * @return
     */
    @Override
    public List<Weather> getWeather(City city) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Weather as c where c.city.cityId=?",Weather.class)
                .setParameter(0,city.getCityId())
                .getResultList();
    }

    @Override
    public boolean searchCity(String cityName) {

        String hql = "select count(*) from City as o where o.districtName=?";

        Long count = (Long) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,cityName)
                .uniqueResult();
        return count>0?true:false;
    }


    @Override
    public City getCity(String cityName) {
//        return sessionFactory.getCurrentSession().get(CityVO.class,cityid);
            return  sessionFactory.getCurrentSession()
                    .createQuery("from City as o where o.districtName=?",City.class)
                    .setParameter(0,cityName)
                    .getSingleResult();
    }


}
