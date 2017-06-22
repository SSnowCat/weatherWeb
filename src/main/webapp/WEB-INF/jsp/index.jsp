<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/21
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>天气网</title>
    <link rel="stylesheet" href="css/index.css" charset="utf-8">

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
                <input type="text" placeholder="输入你要查找的城市">
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
        <div class="forecast clearfix">
            <div class="g_title">
                <span>预报</span>
                <ul class="nav">
                    <li>
                        <a href="javascript:;">15天预报</a>
                    </li>
                </ul>
            </div>
            <ul class="days clearfix">
                <li>
                    <em>今天</em>
                </li>
                <li>
							<span>
                            <img src="img/w1.png" alt="多云">
                        </span> ${day3[0].conditionDay}
                </li>
                <li>20° / 30°</li>
                <li>
                    <em>西北风</em>
                    <b>1级</b>
                </li>
                <li><strong class="level_2">
                    78 良
                </strong>
                </li>
            </ul>
            <ul class="days clearfix">
                <li>
                    <em>明天</em>
                </li>
                <li>
							<span>
                            <img src="img/w1.png" alt="多云">
                        </span> ${day3[1].conditionDay}
                </li>
                <li>23° / 30°</li>
                <li>
                    <em>北风</em>
                    <b>1级</b>
                </li>
                <li><strong class="level_2">
                    69 良
                </strong>
                </li>
            </ul>
            <ul class="days clearfix">
                <li>
                    <em>后天</em>
                </li>
                <li>
							<span>
                            <img src="img/w1.png" alt="多云">
                        </span> ${day3[2].conditionDay}
                </li>
                <li>23° / 31°</li>
                <li>
                    <em>东北风</em>
                    <b>2级</b>
                </li>
                <li><strong class="level_2">
                    70 良
                </strong>
                </li>
            </ul>
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
                                    <em>29°</em>
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
                                    <em>29°</em>
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
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/7.png">
                                                    </span>
                            <dl>
                                <dt>控油</dt>
                                <dd>化妆</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/12.png">
                                                    </span>
                            <dl>
                                <dt>极易发</dt>
                                <dd>感冒</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/17.png">
                                                    </span>
                            <dl>
                                <dt>较不适宜</dt>
                                <dd>洗车</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/0.png">
                                                    </span>
                            <dl>
                                <dt>较差</dt>
                                <dd>空气污染扩散</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/20.png">
                                                    </span>
                            <dl>
                                <dt>闷热</dt>
                                <dd>穿衣</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/21.png">
                                                    </span>
                            <dl>
                                <dt>弱</dt>
                                <dd>紫外线</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/26.png">
                                                    </span>
                            <dl>
                                <dt>适宜</dt>
                                <dd>运动</dd>
                            </dl>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="clearfix">
									<span>
                                                            <img src="img/28.png">
                                                    </span>
                            <dl>
                                <dt>较适宜</dt>
                                <dd>钓鱼</dd>
                            </dl>
                        </a>
                    </li>
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
