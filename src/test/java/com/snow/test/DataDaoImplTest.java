package com.snow.test;

import com.snow.weather.domain.City;
import com.snow.weather.persistence.DataDao;
import com.snow.weather.util.AnalyseJSON;
import com.snow.weather.util.GetJSON;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/6/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
@Transactional
@Rollback(false)
public class DataDaoImplTest {
//    private static final String LAT = "39.91488908";
//    private static final String LON = "116.40387397";
//    private static City city;
//    @Autowired
//    private DataDao dataDao;
//
//    @BeforeClass
//    public static void init(){
//        city = AnalyseJSON.getCity(GetJSON.getLifeJson(LAT,LON));
//    }
//
//    @Test
//    public void testSaveCity(){
//       dataDao.saveCity("北京");
//
//    }
//
//    @Test
//    public void testSaveLife(){
//        dataDao.saveLife(city.getCityName());
//    }
//
//    @Test
//    public void testSaveTemp(){
//        dataDao.saveTemp(city.getCityName());
//    }
//
//    @Test
//    public void testSaveWeather(){
//        dataDao.saveWeather("北京");
//    }

}
