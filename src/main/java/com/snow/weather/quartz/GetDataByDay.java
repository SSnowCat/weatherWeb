package com.snow.weather.quartz;

import com.snow.weather.persistence.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/6/23.
 */
@Transactional
@Component("getDataByDay")
public class GetDataByDay {

    @Autowired
    private DataDao dataDao;

    public void getDataByDay(){
        System.out.println("getHotDataByDay.....");
//        String hotCity = "北京";
//        dataDao.saveTemp(hotCity);
//        dataDao.saveLife(hotCity);
//        dataDao.deleteAllWeather();
//        dataDao.saveWeather(hotCity);
    }
}
