package com.snow.test;

import com.snow.weather.domain.City;
import com.snow.weather.service.UserService;
import com.snow.weather.serviceImpl.UserServiceImpl;
import com.snow.weather.vo.LiveIndexVO;
import com.snow.weather.vo.WeatherBriefVO;
import com.snow.weather.vo.WeatherDetailsVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
@Transactional
@Rollback(false)

public class UserServiceTest {

//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void testWeatherDetails(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        WeatherDetailsVO weatherDetails=userService.getWeatherDetailsVO(city);
//        Assert.assertEquals(22,weatherDetails.getTemp());
//    }
//    @Test
//    public void testWeatherBriefVO(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        List<WeatherBriefVO> weatherBriefVOList= userService.getWeatherBriefVO(city);
//        Assert.assertEquals(23,weatherBriefVOList.get(0).getTempDay());
//    }
//    @Test
//    public void testLiveIndexVO(){
//        City city =new City();
//        city.setCityName("西城区");
//        city.setCityId(284610);
//        List<LiveIndexVO> liveIndexVOS=userService.getLiveIndexVOs(city);
//        Assert.assertEquals(true,liveIndexVOS.get(0).getStatus().equals("控油"));
//    }
}
