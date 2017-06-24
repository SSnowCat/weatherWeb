package com.snow.weather.controller;

import com.snow.weather.domain.City;
import com.snow.weather.domain.Temp;
import com.snow.weather.service.UserService;
import com.snow.weather.util.GetLatAndLngByBaidu;
import com.snow.weather.vo.CityVO;
import com.snow.weather.vo.LiveIndexVO;
import com.snow.weather.vo.WeatherBriefVO;
import com.snow.weather.vo.WeatherDetailsVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FakeController {

    String locateCity = "西城区";

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String toIndex(HttpSession session) {
        makeFakeData(session);
        return "index";
    }

    @GetMapping(value = "/getChartData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getChartData() {
        String data = "";
        List<Temp> list = userService.getTemp(userService.getCity(locateCity));
        for(int i = 0; i <= list.size();i++){
            if (i == 23){
                data = "[" + data + "{\"Ftemp\":"+ list.get(i).getTemp() +",\"Fpredict_hour\":"+ list.get(i).getHour() +",\"wind_level\":2}" + "]";
                break;

            }
            data = data + "{\"Ftemp\":"+ list.get(i).getTemp() +",\"Fpredict_hour\":"+ list.get(i).getHour() +",\"wind_level\":2}," ;
        }

        return data;
    }

    @GetMapping(value = "/citySearch/{word}", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCitySearch(@PathVariable String word) {
        String data = "[{\"counname\":\"中国\",\"name\":\"临汾市\",\"pname\":\"山西省\"},{\"counname\":\"中国\",\"name\":\"乐山市\",\"pname\":\"四川省\"},{\"counname\":\"中国\",\"name\":\"兰州市\",\"pname\":\"甘肃省\"},{\"counname\":\"中国\",\"name\":\"娄底市\",\"pname\":\"湖南省\"},{\"counname\":\"中国\",\"name\":\"廊坊市\",\"pname\":\"河北省\"}]";
        return data;
    }

    @GetMapping("/weather/{name}")
    public String getWeather(@PathVariable String name, HttpSession session) {
        locateCity = name;
        makeFakeData(session);
        return "redirect: /index";
    }

    @GetMapping(value = "/geolocate/{lon}/{lat}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String geolocate(@PathVariable String lon, @PathVariable String lat) {
        GetLatAndLngByBaidu getLatAndLngByBaidu = new GetLatAndLngByBaidu();
        locateCity = getLatAndLngByBaidu.getLocateToCityname(lon,lat);
        return "/weather/"+locateCity;
    }

    @GetMapping(value = "/defaultlocate", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String defaultLocate() {
        String data = "/weather/"+locateCity;
        return data;
    }

    private void makeFakeData(HttpSession session) {
        City city = userService.getCity(locateCity);
        CityVO cityVO = new CityVO();
        cityVO.setCounname(city.getCunName());
        cityVO.setPname(city.getCityName());
        cityVO.setName(city.getDistrictName());

        session.setAttribute("city", cityVO);

        WeatherDetailsVO details = userService.getWeatherDetailsVO(city);
        session.setAttribute("details", details);

        List<WeatherBriefVO> day3 = userService.getWeatherBriefVO(city);
        session.setAttribute("day3", day3);

        List<LiveIndexVO> liveIndex = userService.getLiveIndexVOs(city);
        session.setAttribute("liveIndex",liveIndex);

        List<WeatherBriefVO> day15 = userService.getTwoWeekBriefVO(city);
        session.setAttribute("day15", day15);
    }

}
