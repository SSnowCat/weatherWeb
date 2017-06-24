package com.snow.weather.controller;

import com.snow.weather.vo.CityVO;
import com.snow.weather.vo.LiveIndexVO;
import com.snow.weather.vo.WeatherBriefVO;
import com.snow.weather.vo.WeatherDetailsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李德阳 on 2017/6/21.
 */
@Controller
public class FakeController {

    @GetMapping("/index")
    public String toIndex(HttpSession session) {
        fakeDataMake(session);
        return "index";
    }

    @GetMapping(value = "/getChartData", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getChartData() {
        String data = "[{\"Ftemp\":26,\"Fpredict_hour\":12,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":13,\"wind_level\":2},{\"Ftemp\":26,\"Fpredict_hour\":23,\"wind_level\":2},{\"Ftemp\":27,\"Fpredict_hour\":0,\"wind_level\":2}]";
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
        fakeDataMake(session);
        return "redirect: /index";
    }

    @GetMapping(value = "/geolocate/{lon}/{lat}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String geolocate(@PathVariable String lon, @PathVariable String lat) {
        String data = "/weather/成都";
        return data;
    }

    @GetMapping(value = "/defaultlocate", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String defaultLocate() {
        String data = "/weather/北京";
        return data;
    }

    private void fakeDataMake(HttpSession session) {
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
        session.setAttribute("details", details);

        List<WeatherBriefVO> day3 = new ArrayList<>();

        WeatherBriefVO weatherBriefVO1 = new WeatherBriefVO();
        weatherBriefVO1.setPredictDay("今天");
        weatherBriefVO1.setConditionDay("小雨");
        weatherBriefVO1.setConIconDay("5");
        weatherBriefVO1.setTempDay(32);
        weatherBriefVO1.setTempNight(21);
        weatherBriefVO1.setWindDir("东南风");
        weatherBriefVO1.setWindLevel(3);
        weatherBriefVO1.setAqiLevel(2);
        weatherBriefVO1.setAqiStr("56 良");
        weatherBriefVO1.setAqiIcon("2");
        day3.add(weatherBriefVO1);

        WeatherBriefVO weatherBriefVO2 = new WeatherBriefVO();
        weatherBriefVO2.setPredictDay("明天");
        weatherBriefVO2.setConditionDay("多云");
        weatherBriefVO2.setConIconDay("4");
        weatherBriefVO2.setTempDay(22);
        weatherBriefVO2.setTempNight(21);
        weatherBriefVO2.setWindDir("东风");
        weatherBriefVO2.setWindLevel(4);
        weatherBriefVO2.setAqiLevel(1);
        weatherBriefVO2.setAqiStr("46 优");
        weatherBriefVO2.setAqiIcon("2");
        day3.add(weatherBriefVO2);

        WeatherBriefVO weatherBriefVO3 = new WeatherBriefVO();
        weatherBriefVO3.setPredictDay("后天");
        weatherBriefVO3.setConditionDay("小雨");
        weatherBriefVO3.setConIconDay("5");
        weatherBriefVO3.setTempDay(32);
        weatherBriefVO3.setTempNight(21);
        weatherBriefVO3.setWindDir("东南风");
        weatherBriefVO3.setWindLevel(3);
        weatherBriefVO3.setAqiLevel(2);
        weatherBriefVO3.setAqiStr("76 良");
        weatherBriefVO3.setAqiIcon("2");
        day3.add(weatherBriefVO3);

        session.setAttribute("day3", day3);

        List<LiveIndexVO> liveIndex = new ArrayList<>();
        LiveIndexVO live1 = new LiveIndexVO();
        live1.setName("化妆");
        live1.setStatus("控油");
        live1.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live1);

        LiveIndexVO live2 = new LiveIndexVO();
        live2.setName("感冒");
        live2.setStatus("易发");
        live2.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live2);

        LiveIndexVO live3 = new LiveIndexVO();
        live3.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        live3.setName("洗车");
        live3.setStatus("较适宜");
        liveIndex.add(live3);

        LiveIndexVO live4 = new LiveIndexVO();
        live4.setName("空气污染扩散");
        live4.setStatus("中");
        live4.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live4);

        LiveIndexVO live5 = new LiveIndexVO();
        live5.setName("穿衣");
        live5.setStatus("热");
        live5.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live5);

        LiveIndexVO live6 = new LiveIndexVO();
        live6.setName("紫外线");
        live6.setStatus("弱");
        live6.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live6);

        LiveIndexVO live7 = new LiveIndexVO();
        live7.setName("运动");
        live7.setStatus("适宜");
        live7.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live7);

        LiveIndexVO live8 = new LiveIndexVO();
        live8.setName("钓鱼");
        live8.setStatus("较适宜");
        live8.setDesc("天气较好，且紫外线辐射不强，适宜户外运动。");
        liveIndex.add(live8);

        session.setAttribute("liveIndex",liveIndex);

        List<WeatherBriefVO> day15 = new ArrayList<>();
        for (int i=0;i<15;i++) {
            WeatherBriefVO weatherBriefVO = new WeatherBriefVO();
            weatherBriefVO.setPredictDay("后天");
            weatherBriefVO.setConditionDay("小雨");
            weatherBriefVO.setConditionNight("多云");
            weatherBriefVO.setConIconDay("5");
            weatherBriefVO.setConIconNight("5");
            weatherBriefVO.setTempDay(32);
            weatherBriefVO.setTempNight(21);
            weatherBriefVO.setWindDir("东南风");
            weatherBriefVO.setWindLevel(3);
            weatherBriefVO.setAqiLevel(2);
            weatherBriefVO.setAqiStr("76 良");
            weatherBriefVO.setAqiIcon("2");
            day15.add(weatherBriefVO);
        }

        session.setAttribute("day15", day15);
    }

}
