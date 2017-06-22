package com.snow.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by 李德阳 on 2017/6/21.
 */
@Controller
public class MainController {

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    @GetMapping(value = "/getChartData",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getChartData(){
        String data = "[{\"Ftemp\":26,\"Fpredict_hour\":12,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":13,\"wind_level\":2},{\"Ftemp\":26,\"Fpredict_hour\":14,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":15,\"wind_level\":2}]";
        return data;
    }

    @GetMapping(value = "/citySearch/{word}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getCitySearch(@PathVariable String word){
        String data = "{\"city_list\":[{\"cityId\":2635,\"city_lable\":[],\"counname\":\"中国\",\"id\":53,\"localCounname\":\"中国\",\"localName\":\"成都市\",\"localPname\":\"四川省\",\"name\":\"成都市\",\"pname\":\"四川省\"}],\"rc\":{\"c\":0}}";
        return data;
    }

    @GetMapping(value = "/weather/{name}")
    public String getWeather(@PathVariable String name,HttpSession session){
        return "redirect: /index";
    }
}
