package com.snow.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/6/21.
 */
@Controller
public class MainController {

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    @GetMapping("/getChartData")
    @ResponseBody
    public String getChartData(){
        String data = "[{\"Ftemp\":26,\"Fpredict_hour\":12,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":13,\"wind_level\":2},{\"Ftemp\":26,\"Fpredict_hour\":14,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":15,\"wind_level\":2}]";
        return data;
    }
}
