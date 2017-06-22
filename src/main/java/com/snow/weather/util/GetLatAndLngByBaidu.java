package com.snow.weather.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取经纬度
 *
 * @author jueyue 返回格式：Map<String,Object> map map.put("status",
 * reader.nextString());//状态 map.put("result", list);//查询结果
 * list<map<String,String>>
 * 密钥:f247cdb592eb43ebac6ccd27f796e2d2
 */
public class GetLatAndLngByBaidu {

    /**
     * @param address
     * 查询的地址
     * @return
     * @throws IOException
     */
    public String[] getCoordinate(String address) {
        String host = "http://jisujwddz.market.alicloudapi.com";
        String path = "/geoconvert/addr2coord";
        String method = "GET";
        String appcode = "44325ff075574eeba7b44bd5180d2c1f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("address", address);
        querys.put("type", "google");
        String lat = null;
        String lng = null;

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
            String json = EntityUtils.toString(response.getEntity());
            lat = (String)JSONObject.parseObject(json)
                    .getJSONObject("result").get("lat");
            lng = (String)JSONObject.parseObject(json)
                    .getJSONObject("result").get("lng");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[]{lat,lng};

    }
}