package com.snow.test;





import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.snow.weather.domain.CitySearch;
import com.snow.weather.util.GetJSON;
import com.snow.weather.vo.CityVO;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/20.
 */
public class GetJSONTest {
    @Test
    public  void sendGet() {
        String s= GetJSON.getCityImaging("http://tianqi.moji.com/api/citysearch", "chengdu");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray cityList = jsonObject.getJSONArray("city_list");
        List<CitySearch> list = JSONObject.parseArray(cityList.toJSONString(), CitySearch.class);
        String data = "";
        for (int i = 0; i < list.size();i++) {
            if (i == list.size() - 1) {

                data = "[" + data + "{\"counname\":" + list.get(i).getCounname() + ",\"name\":" + list.get(i).getName() + ",\"pname\":" + list.get(i).getPname() + "}" + "]";
                break;
            }
            data = data + "{\"counname\":" + list.get(i).getCounname() + ",\"name\":" + list.get(i).getName() + ",\"pname\":" + list.get(i).getPname() + "},";


        }
        System.out.println(data);
        //System.out.println(cityList);

       // System.out.println(s);
    }
}
