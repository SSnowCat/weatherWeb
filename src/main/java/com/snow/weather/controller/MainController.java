package com.snow.weather.controller;

import com.snow.weather.vo.CityVO;
import com.snow.weather.vo.WeatherBriefVO;
import com.snow.weather.vo.WeatherDetailsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李德阳 on 2017/6/21.
 */
@Controller
public class MainController {

    @GetMapping("/index")
    public String toIndex(HttpSession session){
        init(session);
        return "index";
    }

    @GetMapping(value = "/getChartData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getChartData(){
        String data = "[{\"Ftemp\":26,\"Fpredict_hour\":12,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":13,\"wind_level\":2},{\"Ftemp\":26,\"Fpredict_hour\":23,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":0,\"wind_level\":2}]";
        return data;
    }

    @GetMapping(value = "/citySearch/{word}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCitySearch(@PathVariable String word){
        String data = "[{\"counname\":\"中国\",\"name\":\"临汾市\",\"pname\":\"山西省\"},{\"counname\":\"中国\",\"name\":\"乐山市\",\"pname\":\"四川省\"},{\"counname\":\"中国\",\"name\":\"兰州市\",\"pname\":\"甘肃省\"},{\"counname\":\"中国\",\"name\":\"娄底市\",\"pname\":\"湖南省\"},{\"counname\":\"中国\",\"name\":\"廊坊市\",\"pname\":\"河北省\"}]";
        return data;
    }

    @GetMapping("/weather/{name}")
    public String getWeather(@PathVariable String name, HttpSession session){
        init(session);
        return "redirect: /index";
    }

    @GetMapping(value = "/geolocate/{lon}/{lat}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String geolocate(@PathVariable String lon,@PathVariable String lat){
        String data = "/weather/成都";
        return data;
    }

    @GetMapping(value = "/iplocate",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String iplocate(){
        String data = "/weather/北京";
        return data;
    }

    private void init(HttpSession session){
        CityVO cityVO = new CityVO();
        cityVO.setCounname("中国");
        cityVO.setPname("四川省");
        cityVO.setName("西昌市");
        session.setAttribute("city", cityVO);
        WeatherDetailsVO details = new WeatherDetailsVO();
        details.setCondition("雪");
        details.setHumidity(56);
        details.setConIcon("2");
        details.setAqiLevel(1);
        details.setAqiStr("23 优");
        details.setAqiIcon("2");
        details.setTemp(27);
        details.setTips("冷热适宜，感觉很舒适。");
        details.setUpdatetime("今日15：00更新");
        details.setWindDir("西南风");
        details.setWindLevel(4);
        details.setCarLimit("尾号限行 4和6");
        session.setAttribute("details",details);

        List<WeatherBriefVO> day3 = new ArrayList<>();
        for (int i=0;i<3;++i){
            WeatherBriefVO weatherBriefVO = new WeatherBriefVO();
            weatherBriefVO.setConditionDay("小雨");
            weatherBriefVO.setConIconDay("5");
            weatherBriefVO.setTempDay(32);
            weatherBriefVO.setTempNight(21);
            weatherBriefVO.setWindDir("东南风");
            weatherBriefVO.setWindLevel(3);
            weatherBriefVO.setAqiLevel(2);
            weatherBriefVO.setAqiStr("76 良");
            weatherBriefVO.setAqiIcon("2");
            day3.add(weatherBriefVO);
        }
        session.setAttribute("day3",day3);
    }

}
