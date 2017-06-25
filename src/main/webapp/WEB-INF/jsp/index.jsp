<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>天气网</title>
    <link rel="stylesheet" href="css/index.css" charset="utf-8">
    <link rel="stylesheet" href="css/chanle.css" charset="utf-8">

</head>

<body>
<div id="skin" style="background: url(/img/day_1.jpg) center top / 1423px no-repeat;"></div>

<div class="wrap clearfix">
    <div class="comm_box">
        <div class="crumb clearfix">
            <ul>
                <li>
                    <a href="javascript:;">天气</a>
                    <i></i>
                </li>
                <li>
                    <a href="javascript:;">${city.counname}</a>
                    <i></i>
                </li>
                <li>
                    <a href="javascript:;">${city.pname}</a>
                    <i></i>
                </li>
                <li>${city.name}</li>
            </ul>
        </div>
    </div>
    <div id="search">
        <div class="search">
            <div class="search_default">
                <em>${city.name}， ${city.pname}， ${city.counname}</em>
                <strong id="locate"></strong>
                <b><!--icon--></b>
                <input type="text" name="cityname" id="cityname" placeholder="输入你要查找的城市">
                <i></i>
            </div>
        </div>
        <div class="search_city" style="display: none;">
            <ul></ul>
        </div>
    </div>
</div>
<div class="wrap clearfix wea_info">
    <div class="left">
        <div class="wea_alert clearfix">
            <ul>
                <li>
                    <a href="javascript:;">
                        <span class="level level_${details.aqiLevel}">
                            <img src="img/${details.aqiIcon}.png" alt="${details.aqiStr}">
                        </span>
                        <em>${details.aqiStr}</em>
                    </a>
                </li>
            </ul>
        </div>
        <div class="wea_weather clearfix">
            <em>${details.temp}</em>
            <span><img src="img/w${details.conIcon}.png" alt="${details.condition}"></span>
            <b>${details.condition}</b>
            <strong class="info_uptime">${details.updatetime}</strong>
        </div>
        <div class="wea_about clearfix">
            <span>湿度 ${details.humidity}%</span>
            <em>${details.windDir}&nbsp;${details.windLevel}级</em>
            <b>${details.carLimit}</b></div>
        <div class="wea_tips clearfix">
            <span>今日天气提示</span>
            <em>${details.tips}</em>
        </div>
    </div>
</div>
<div class="wrap clearfix">
    <div class="left">
        <div id="brief_future" class="forecast clearfix">
            <div class="g_title">
                <span>预报</span>
                <ul class="nav">
                    <li>
                        <a href="javascript:showDay15();">15天预报</a>
                    </li>
                </ul>
            </div>
            <c:forEach items="${day3}" var="day">
                <ul class="days clearfix">
                    <li>
                        <em>${day.predictDay}</em>
                    </li>
                    <li>
                <span>
                    <img src="img/w${day.conIconDay}.png" alt="${day.conditionDay}">
                </span> ${day.conditionDay}
                    </li>
                    <li>${day.tempNight}° / ${day.tempDay}°</li>
                    <li>
                        <em>${day.windDir}</em>
                        <b>${day.windLevel}级</b>
                    </li>
                    <li>
                        <strong class="level_${day.aqiLevel}">
                                ${day.aqiStr}
                        </strong>
                    </li>
                </ul>
            </c:forEach>

        </div>

        <div id="detail_future" style="display: none;">
            <div class="g_title">
                <span>15天预报</span>
                <ul class="nav">
                    <li>
                        <a href="javascript:showDay3();">3天预报</a>
                    </li>
                </ul>
            </div>
            <div class="detail_future_grid">
                <div class="prev" style="display: none;"></div>
                <div class="wea_list clearfix">
                    <ul class="clearfix" style="width: 1120px; margin-left: 0px;">
                    <c:forEach items="${day15}" var="day">
                        <li>
                            <span class="week">${day.predictWeek}</span>
                            <span class="wea" style="font-size: 12px;">${day.conditionDay}</span>
                            <span class="weai">
                                <img src="img/w${day.conIconDay}.png" alt="${day.conditionDay}">
                            </span>
                            <div class="tree clearfix">
                                <p style="top: 0px; bottom: 18.6667px;">
                                    <b>${day.tempDay}°</b>
                                    <strong>${day.tempNight}°</strong>
                                </p>
                            </div>
                            <span class="weai">
                                <img src="img/w${day.conIconNight}.png" alt="${day.conditionNight}">
                            </span>
                            <span class="wea" style="font-size: 12px;">${day.conditionNight}</span>
                            <span class="week">${day.predictDate}</span>
                        </li>
                    </c:forEach>
                    </ul>
                </div>
                <div class="next"></div>
            </div>
        </div>

        <div class="hours">
            <div class="g_title">
                <span>24小时预报</span>
                <ul class="nav">
                    <li class="active">温度</li>
                    <li>风力</li>
                </ul>
            </div>
            <div class="charts clearfix">
                <div class="chart chart_temp clearfix" id="chart_temp">
                    <div class="prev"></div>
                    <div class="next"></div>
                    <div class="num">
                        <span>33°</span>
                        <span>30°</span>
                        <span>26°</span>
                        <span>23°</span>
                    </div>
                    <div class="canvas">
                        <div class="canvas_box">
                            <canvas width="4000" height="300" id="temp"></canvas>
                            <div class="canvas_point">
                                <span></span>
                                <div>
                                    <em></em>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="chart chart_wind clearfix" id="chart_wind" style="display: none;">
                    <div class="prev"></div>
                    <div class="next"></div>
                    <div class="num">
                        <span></span>
                        <span>2级</span>
                        <span></span>
                        <span>1级</span>
                    </div>
                    <div class="canvas">
                        <div class="canvas_box">
                            <canvas width="4000" height="300" id="wind"></canvas>
                            <div class="canvas_point">
                                <span></span>
                                <div>
                                    <em></em>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--生活指数-->
        <div id="live_index">
            <div class="live_index_title">
                <h2>生活指数</h2>
                <span></span>
            </div>
            <div class="live_index_grid">
                <ul class="clearfix">
                    <c:forEach items="${liveIndex}" var="live">
                        <li title="${live.desc}">
                            <a href="javascript:;" class="clearfix">
                            <span>
                                <img src="img/${live.icon}.png">
                            </span>
                                <dl>
                                    <dt>${live.status}</dt>
                                    <dd>${live.name}</dd>
                                </dl>
                            </a>
                        </li>
                    </c:forEach>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="js/index.charts.js"></script>
<script src="js/index.js"></script>
<script src="js/forecast.js"></script>


<div class="foot_box clearfix">
    <div class="foot clearfix">

        <div class="foot clearfix">
            <div class="address">
                <p>公司地址：美国加利福利亚圣克拉拉县山景市 联系电话：400-880-0599</p>
            </div>
            <div class="copyright">
                Copyright© 2017-2020 万锋科技股份有限公司 All Rights Reserved<br> 美ICP备10021324号 京公网安备11010502023583
            </div>
        </div>
    </div>
</div>
</body>
</html>
