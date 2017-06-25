package com.snow.weather.service;

/**
 * Created by Administrator on 2017/6/21.
 */

import  com.snow.weather.domain.City;
import com.snow.weather.domain.Life;
import com.snow.weather.domain.Temp;
import com.snow.weather.domain.Weather;
import com.snow.weather.vo.CityVO;
import com.snow.weather.vo.LiveIndexVO;
import com.snow.weather.vo.WeatherBriefVO;
import com.snow.weather.vo.WeatherDetailsVO;

import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.List;

public interface UserService {

    boolean searchCity(String cityName);

    City getCity(String cityName);

    CityVO getCityVO(City city);

    List<LiveIndexVO> getLiveIndexVOs(City city);

    List<WeatherBriefVO> getWeatherBriefVO(City city);//简约天气

    WeatherDetailsVO getWeatherDetailsVO(City city);//天气实况

    List<Temp> getTemp(City city);//获取24小时温度

    List<Weather> getTwoWeeksWeather(City city);//获取两周天气

    List<Life> getLifeIndex(City city);//获取生活指数

    Weather getCurrentWeather(City city);

    Temp getCurrentTemp(City city);

    List<WeatherBriefVO> getTwoWeekBriefVO(City city);

}
