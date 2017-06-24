package com.snow.test;

/**
 * Created by Administrator on 2017/6/21.
 */
import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.persistence.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
@Transactional
@Rollback(false)

public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCity(){

        City city= userDao.getCity("北京市");
        Assert.assertNotEquals(-1,city.getCityId());
    }

    @Test
    public void testLife(){
        City city =new City();
        city.setCityName("广州市");
        city.setCityId(0);
        List<Life> life= userDao.getLife(city);
        Assert.assertNotEquals(-1,life.size());
    }

    @Test
    public void testTemp(){
        City city =new City();
        city.setCityName("北京市");
        city.setCityId(0);
        List<Temp> temp= userDao.getTemp(city);
        Assert.assertNotEquals(-1,temp.size());
    }

    @Test
    public void testWeather(){
        City city =new City();
        city.setCityName("北京市");
        city.setCityId(0);
        List<Weather> weathers= userDao.getWeather(city);
        Assert.assertNotEquals(-1,weathers.size());
    }


}
