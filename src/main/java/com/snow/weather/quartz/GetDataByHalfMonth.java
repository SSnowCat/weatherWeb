package com.snow.weather.quartz;

import com.snow.weather.persistence.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Administrator on 2017/6/23.
 */
@Transactional
@Component("getDataByHalfMonth")
public class GetDataByHalfMonth {

    @Autowired
    private DataDao dataDao;

    public void getDataByHalfMonth(){
        System.out.println("getDataByHalfMonth...");
//        dataDao.deleteAllLife();
//        dataDao.deleteAllTemp();
//        dataDao.deleteAllWarning();
    }

}
