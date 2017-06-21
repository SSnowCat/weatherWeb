package com.snow.weather.persistenceImpl;

import com.snow.weather.domain.*;
import com.snow.weather.persistence.DataDao;
import com.snow.weather.util.AnalyseJSON;
import com.snow.weather.util.GetJSON;
import com.snow.weather.util.GetLatAndLngByBaidu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class DataDaoImpl implements DataDao{

    @Autowired
    private SessionFactory sessionFactory;

    //private String hotCityName = "成都";
    private AnalyseJSON analyseJSON;
    private GetJSON getJSON;
    private GetLatAndLngByBaidu getLatAndLngByBaidu;

    public String[] getl(String cityName){
        String[] o = null;
        try {
            o = getLatAndLngByBaidu.getCoordinate(cityName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public void saveCity(City city) {
        sessionFactory.getCurrentSession().save(city);
    }

    @Override
    public void saveLife(String cityName) {
        List<Life> list;
        list = analyseJSON.getLife(getJSON.getLifeJson(getl(cityName)[0],getl(cityName)[1]));
        for(Life lifelist:list){
            sessionFactory.getCurrentSession().save(lifelist);
        }
    }

    @Override
    public void saveTemp(String cityName) {
        List<Temp> list;
        list = analyseJSON.getTemp(getJSON.getTempJson(getl(cityName)[0],getl(cityName)[1]));
        for(Temp templist:list){
            sessionFactory.getCurrentSession().save(templist);
        }
    }

    @Override
    public void saveWeather(String cityName){
        List<Weather> list = null;
        try {
            list = analyseJSON.getWeather(getJSON.getWeatherJson(getl(cityName)[0],getl(cityName)[1]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(Weather weatherlist:list){
            sessionFactory.getCurrentSession().save(weatherlist);
        }
    }

    @Override
    public void saveWarning(String cityName) {

    }
}
