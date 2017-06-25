package com.snow.test;

/**
 * Created by Administrator on 2017/6/21.
 */
import com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.persistence.UserDao;
import com.snow.weather.service.UserService;
import com.snow.weather.serviceImpl.UserServiceImpl;
import com.snow.weather.vo.WeatherDetailsVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
@Transactional
@Rollback(false)

public class UserDaoTest {

//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void testCity(){
//
//        City city= userDao.getCity("西城区");
//        Assert.assertEquals(284610,city.getCityId());
//    }
//
//    @Test
//    public void testLife(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        List<Life> life= userDao.getLife(city);
//        int x=life.get(0).getId();
//        Assert.assertEquals(33,x);
//    }
//
//    @Test
//    public void testTemp(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        List<Temp> temp= userDao.getTemp(city);
//        int x=temp.get(0).getId();
//        Assert.assertEquals(53,x);
//    }
//
//    @Test
//    public void testWeather(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        List<Weather> weathers= userDao.getWeather(city);
//        int x=weathers.get(0).getId();
//        Assert.assertEquals(65,x);
//    }
//
//
//

}
