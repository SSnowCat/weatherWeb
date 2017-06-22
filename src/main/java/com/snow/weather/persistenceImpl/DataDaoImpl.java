package com.snow.weather.persistenceImpl;

import com.snow.weather.domain.*;
import com.snow.weather.persistence.DataDao;
import com.snow.weather.util.AnalyseJSON;
import com.snow.weather.util.GetJSON;
import com.snow.weather.util.GetLatAndLngByBaidu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
@Repository
public class DataDaoImpl implements DataDao{

    @Autowired
    private SessionFactory sessionFactory;

    //private String hotCityName = "成都";
    private GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();

    public String[] getl(String cityName){
        String[] o = null;
        o = getLatAndLngByBaidu.getCoordinate(cityName);
        return o;
    }


    @Override
    public void saveCity(String cityName) {
        sessionFactory.getCurrentSession().save(AnalyseJSON.getCity(GetJSON.getLifeJson(getl(cityName)[0],getl(cityName)[1])));

    }

    @Override
    public void saveLife(String cityName) {
        List<Life> list;
        //saveCity(AnalyseJSON.getCity(GetJSON.getLifeJson(getl(cityName)[0],getl(cityName)[1])));
        list = AnalyseJSON.getLife(GetJSON.getLifeJson(getl(cityName)[0],getl(cityName)[1]));
        for(Life lifelist:list){
            sessionFactory.getCurrentSession().save(lifelist);
        }
    }

    @Override
    public void saveTemp(String cityName) {
        List<Temp> list;
        list = AnalyseJSON.getTemp(GetJSON.getTempJson(getl(cityName)[0],getl(cityName)[1]));
        for(Temp templist:list){
            sessionFactory.getCurrentSession().save(templist);
        }
    }

    @Override
    public void saveWeather(String cityName){
        List<Weather> list = null;
        try {
            list = AnalyseJSON.getWeather(GetJSON.getWeatherJson(getl(cityName)[0],getl(cityName)[1]));
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
