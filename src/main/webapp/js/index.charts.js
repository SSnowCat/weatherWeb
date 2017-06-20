$(function () {
    function e(e) {
        for (var n = e.hour24, a = {
            y: new Array,
            wea: new Array,
            temp: new Array,
            tempH: -9999,
            tempL: 9999,
            wind: new Array,
            level: new Array,
            levelH: -9999,
            levelL: 9999
        }, i = new Array, r = 0; r < n.length; r++) {
            var l = n[r].Fwind_dir_id;
            l = 1 == l ? 0 : l >= 2 && l <= 4 ? 1 : 5 == l ? 2 : l >= 6 && l <= 8 ? 3 : 9 == l ? 4 : l >= 10 && l <= 12 ? -1 : 13 == l ? -2 : l >= 14 && l <= 16 ? -3 : 0, i.push(l)
        }
        for (var r = 0; r < n.length; r++) a.tempH = a.tempH > n[r].Ftemp ? a.tempH : n[r].Ftemp, a.tempL = a.tempL < n[r].Ftemp ? a.tempL : n[r].Ftemp, a.levelH = a.levelH > n[r].wind_level ? a.levelH : n[r].wind_level, a.levelL = a.levelL < n[r].wind_level ? a.levelL : n[r].wind_level, a.y.push(n[r].Fpredict_hour + ":00"), a.temp.push(n[r].Ftemp), a.level.push(n[r].wind_level);
        t(a)
    }

    function t(e) {
        var t = new n;
        t({
            el: "temp",
            type: "line",
            style: {
                pointSize: 1.2,
                font: "24px Arial"
            },
            data: {
                x: e.y,
                y: e.temp,
                p: e.wea,
                h: e.tempH,
                l: e.tempL
            },
            grid: {
                t: 100,
                r: 40,
                b: 60,
                l: 60
            }
        }), t({
            el: "wind",
            type: "line",
            style: {
                pointSize: 1.2,
                font: "24px Arial"
            },
            data: {
                x: e.y,
                y: e.level,
                p: e.wind,
                h: e.levelH,
                l: e.levelL
            },
            grid: {
                t: 100,
                r: 40,
                b: 60,
                l: 60
            }
        })
    }

    function n() {
        return function (e) {
            var t = h = e.el,
                n = e.grid,
                s = e.style,
                f = (e.type, e.data),
                h = document.getElementById(h),
                p = h.width,
                d = h.height,
                p = h.width - n.r - n.l,
                d = h.height - n.t - n.b,
                c = [],
                o = !1,
                v = {
                    img: new Array,
                    size: 10 * s.pointSize
                },
                x = f.h - f.l;
            if (!h.getContext) return !1;
            if ("wind" == t)
                if (f.h - f.l < 2 && f.h - f.l > 0) $("#chart_" + t).find(".num span").eq(0).text(""), $("#chart_" + t).find(".num span").eq(2).text(""), $("#chart_" + t).find(".num span").eq(1).text(f.h + "级"), $("#chart_" + t).find(".num span").eq(3).text(f.l + "级");
                else if (f.h - f.l == 0) {
                    var o = !0;
                    $("#chart_" + t).find(".num span").eq(0).text(""), $("#chart_" + t).find(".num span").eq(1).text(""), $("#chart_" + t).find(".num span").eq(2).text(f.h + "级"), $("#chart_" + t).find(".num span").eq(3).text("")
                } else $("#chart_" + t).find(".num span").eq(0).text(f.h + parseInt((f.h - f.l) / 2) + "级"), $("#chart_" + t).find(".num span").eq(2).text(f.l + parseInt((f.h - f.l) / 2) + "级"), $("#chart_" + t).find(".num span").eq(1).text(f.h + "级"), $("#chart_" + t).find(".num span").eq(3).text(f.l + "级");
            else if (f.h - f.l < 2 && f.h - f.l > 0) $("#chart_" + t).find(".num span").eq(0).text(""), $("#chart_" + t).find(".num span").eq(1).text(""), $("#chart_" + t).find(".num span").eq(2).text(f.h + "°"), $("#chart_" + t).find(".num span").eq(3).text(f.l + "°");
            else if (f.h - f.l == 0) {
                var o = !0;
                $("#chart_" + t).find(".num span").eq(0).text(""), $("#chart_" + t).find(".num span").eq(1).text(""), $("#chart_" + t).find(".num span").eq(2).text(f.h + "°"), $("#chart_" + t).find(".num span").eq(3).text("")
            } else $("#chart_" + t).find(".num span").eq(0).text(f.h + parseInt((f.h - f.l) / 2) + "°"), $("#chart_" + t).find(".num span").eq(2).text(f.l + parseInt((f.h - f.l) / 2) + "°"), $("#chart_" + t).find(".num span").eq(1).text(f.h + "°"), $("#chart_" + t).find(".num span").eq(3).text(f.l + "°");
            var m = h.getContext("2d");
            m.beginPath(), m.strokeStyle = "rgb(255, 255, 255)", m.lineWidth = "4";
            for (var u = 0; u < f.x.length; u++) {
                if (o) var _ = parseInt(n.t + d / 2);
                else var _ = parseInt(n.t + d / x * (f.h - f.y[u]));
                var y = parseInt(n.l + p / (f.x.length - 1) * u);
                m.lineTo(y, _)
            }
            m.stroke();
            for (var u = 0; u < f.x.length; u++) {
                var _ = parseInt(n.l + p / (f.x.length - 1) * u);
                if (o) var y = parseInt(n.t + d / 2);
                else var y = parseInt(n.t + d / x * (f.h - f.y[u]));
                c.push({
                    x: parseInt(_ / 2),
                    y: parseInt(y / 2)
                }), m.beginPath(), m.arc(parseInt(_), parseInt(y), v.size, 0, 2 * Math.PI, !0), m.fillStyle = "#ffffff", m.fill(), m.closePath(), m.stroke()
            }
            m.fillStyle = "#fff", m.font = s.font, m.textAlign = "center";
            for (var u = 0; u < f.x.length; u++) {
                var _ = parseInt(n.l + p / (f.x.length - 1) * u);
                m.fillText(f.x[u], _, d + n.t + n.b / 2 + 25)
            }
            h.addEventListener("mousemove", function (e) {
                var n = l(e);
                r(n, c, v.size, f, t)
            }, !1), a(t, p / (f.x.length - 1)), i(t, p / (f.x.length - 1))
        }
    }

    function a(e, t) {
        var e = $("#chart_" + e),
            n = ($(e).find(".canvas").width(), $(e).find(".canvas_box").width(), !0);
        e.find(".prev").on("click", function () {
            if (n) {
                n = !1;
                var a = $(e).find(".canvas_box").offset().left - 220 + 3 * t,
                    a = a > 0 ? 0 : a;
                $(e).find(".canvas_box").animate({
                    left: a
                }, function () {
                    n = !0
                })
            }
        })
    }

    function i(e, t) {
        var e = $("#chart_" + e),
            n = $(e).find(".canvas").width(),
            a = $(e).find(".canvas_box").width(),
            i = !0;
        e.find(".next").on("click", function () {
            if (i) {
                i = !1;
                var r = $(e).find(".canvas_box").offset().left - 220 - 3 * t,
                    r = -r < a - n ? r : n - a;
                $(e).find(".canvas_box").animate({
                    left: r
                }, function () {
                    i = !0
                })
            }
        })
    }

    function r(e, t, n, a, i) {
        if (!t && !e) return !1;
        for (var r = "wind" == i ? "级" : "°", n = .5 * n, l = 0; l < t.length; l++) {
            var s = t[l].x,
                f = t[l].y;
            if (s - n < e.x && e.x < s + n && f - n < e.y && e.y < f + n) {
                var h = $("#chart_" + i + " .canvas_box").offset().left,
                    p = t[l].x - 39,
                    i = "#chart_" + i + " .canvas_point";
                return $(i).show(), p + h - 220 < 0 ? ($(i).addClass("canvas_point_left"), $(i).css({
                    top: t[l].y - 50,
                    left: t[l].x - 11
                })) : p + h - 220 > 555 ? ($(i).addClass("canvas_point_right"), $(i).css({
                    top: t[l].y - 50,
                    left: t[l].x - 62
                })) : $(i).css({
                    top: t[l].y - 50,
                    left: t[l].x - 39
                }), $(i + " div em").text(a.y[l] + r), $(i + " div img").attr("src", a.p[l]), "级" == r ? $(i + " div img").css({
                    width: "18px",
                    height: "18px"
                }) : $(i + " div img").css({
                    width: "28px",
                    height: "28px"
                }), !1
            }
            $(".canvas_point").removeClass("canvas_point_left").removeClass("canvas_point_right").hide()
        }
    }

    function l(e) {
        var t, n;
        return e.layerX || 0 == e.layerY ? (t = e.layerX, n = e.layerY) : (e.offsetX || 0 == e.offsetY) && (t = e.offsetX, n = e.offsetY), {
            x: t,
            y: n
        }
    }

    var s = $("#staticdomain").val(),
        f = $("#staticmd5").val();
    $(".hours .nav li").on("click", function () {
        $(".hours .nav li").removeClass("active"), $(".hours .charts .chart").hide(), $(this).addClass("active");
        var e = $(this).index();
        "0" == e ? $("#chart_temp").show() : $("#chart_wind").show()
    }),
        /*
         ,$.ajax({
         //http://tianqi.moji.com/index/getHour24
         url: "/index/getHour24",
         type: "GET",
         success: function(t) {
         var t = JSON.parse(t);
         e(t)
         }
         })
         */
        //静态数据测试
        result = '{"hour24":[{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":8,"Ficon_id":1,"Ftemp":26,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":35,"Fpredict_hour":12,"Fhumidity":66,"id":129295383,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":27,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":36,"Fpredict_hour":13,"Fhumidity":63,"id":129306410,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":27,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":36,"Fpredict_hour":14,"Fhumidity":61,"id":129312299,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":28,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":34,"Fpredict_hour":15,"Fhumidity":56,"id":129318186,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u9634","Fcondition_id":13,"Ficon_id":2,"Ftemp":30,"Fwspd":"9","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":33,"Fpredict_hour":16,"Fhumidity":52,"id":129324070,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u9634","Fcondition_id":13,"Ficon_id":2,"Ftemp":29,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":31,"Fpredict_hour":17,"Fhumidity":52,"id":129329951,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u9634","Fcondition_id":13,"Ficon_id":2,"Ftemp":28,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":29,"Fpredict_hour":18,"Fhumidity":56,"id":129335842,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u9634","Fcondition_id":13,"Ficon_id":2,"Ftemp":27,"Fwspd":"7","Fwdir":"WSW","Fwind_dir_id":12,"Ffeelslike":29,"Fpredict_hour":19,"Fhumidity":64,"id":129341719,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u9634","Fcondition_id":13,"Ficon_id":2,"Ftemp":26,"Fwspd":"7","Fwdir":"WSW","Fwind_dir_id":12,"Ffeelslike":28,"Fpredict_hour":20,"Fhumidity":70,"id":129347602,"wind_level":2},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":25,"Fwspd":"5","Fwdir":"WSW","Fwind_dir_id":12,"Ffeelslike":28,"Fpredict_hour":21,"Fhumidity":72,"id":129353497,"wind_level":1},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":24,"Fwspd":"5","Fwdir":"W","Fwind_dir_id":13,"Ffeelslike":27,"Fpredict_hour":22,"Fhumidity":74,"id":129359375,"wind_level":1},{"Fpredict_date":"2017-06-20","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"WNW","Fwind_dir_id":14,"Ffeelslike":26,"Fpredict_hour":23,"Fhumidity":76,"id":129365267,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"W","Fwind_dir_id":13,"Ffeelslike":26,"Fpredict_hour":0,"Fhumidity":78,"id":129436596,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"WSW","Fwind_dir_id":12,"Ffeelslike":25,"Fpredict_hour":1,"Fhumidity":80,"id":129436597,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"SW","Fwind_dir_id":11,"Ffeelslike":24,"Fpredict_hour":2,"Fhumidity":81,"id":129436598,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"SW","Fwind_dir_id":11,"Ffeelslike":24,"Fpredict_hour":3,"Fhumidity":84,"id":129436599,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"5","Fwdir":"SW","Fwind_dir_id":11,"Ffeelslike":23,"Fpredict_hour":4,"Fhumidity":83,"id":129436600,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u6674","Fcondition_id":5,"Ficon_id":30,"Ftemp":23,"Fwspd":"5","Fwdir":"SW","Fwind_dir_id":11,"Ffeelslike":23,"Fpredict_hour":5,"Fhumidity":89,"id":129436601,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":31,"Ftemp":23,"Fwspd":"7","Fwdir":"SW","Fwind_dir_id":11,"Ffeelslike":23,"Fpredict_hour":6,"Fhumidity":94,"id":129436602,"wind_level":2},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":24,"Fwspd":"5","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":27,"Fpredict_hour":7,"Fhumidity":89,"id":129436603,"wind_level":1},{"Fpredict_date":"2017-06-21","Fcondition":"\u6674","Fcondition_id":5,"Ficon_id":0,"Ftemp":24,"Fwspd":"7","Fwdir":"SSW","Fwind_dir_id":10,"Ffeelslike":31,"Fpredict_hour":8,"Fhumidity":82,"id":129436604,"wind_level":2},{"Fpredict_date":"2017-06-21","Fcondition":"\u6674","Fcondition_id":5,"Ficon_id":0,"Ftemp":25,"Fwspd":"7","Fwdir":"S","Fwind_dir_id":9,"Ffeelslike":33,"Fpredict_hour":9,"Fhumidity":73,"id":129436605,"wind_level":2},{"Fpredict_date":"2017-06-21","Fcondition":"\u6674","Fcondition_id":5,"Ficon_id":0,"Ftemp":26,"Fwspd":"7","Fwdir":"S","Fwind_dir_id":9,"Ffeelslike":35,"Fpredict_hour":10,"Fhumidity":66,"id":129436606,"wind_level":2},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":27,"Fwspd":"7","Fwdir":"S","Fwind_dir_id":9,"Ffeelslike":36,"Fpredict_hour":11,"Fhumidity":60,"id":129436607,"wind_level":2},{"Fpredict_date":"2017-06-21","Fcondition":"\u5c11\u4e91","Fcondition_id":12,"Ficon_id":1,"Ftemp":28,"Fwspd":"7","Fwdir":"S","Fwind_dir_id":9,"Ffeelslike":36,"Fpredict_hour":12,"Fhumidity":56,"id":129436610,"wind_level":2}],"sunset":{"date":"2017-06-20","sunrise":"2017-06-21 06:01:00","sundown":"2017-06-20 20:09:00","sunrise_h":"06","sundown_h":"08"}}';
    var jsonResult = JSON.parse(result);
    e(jsonResult);
});
//# sourceMappingURL=index.charts.js.map