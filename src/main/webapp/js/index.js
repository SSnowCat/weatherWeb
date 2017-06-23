function getCitys(e) {
    $.ajax({
        url: 'citySearch/' + e,
        async: !0,
        success: function (e) {
            void 0 != e && setSearchCitys(e)
        },
        error: function (e) {
            console.log(e)
        }
    })
}


function setSearchCitys(e) {
    for (var t = new Array, a = 0; a < e.length; a++)
        if ("中国" == e[a].counname) {
            var n = '<li><a href="weather/' + e[a].name + '">' + e[a].name + "," + e[a].pname + "," + e[a].counname + "</a></li>";
            t.push(n);
        }
    $(".search_city ul").html(t)
}



function getPosition() {
    $("#locate").css({
        background: "url(icon/i_loading.png) no-repeat right center"
    });
    navigator.geolocation ? navigator.geolocation.getCurrentPosition(showCity, function (e) {
        $.ajax({
            url: 'defaultlocate',
            data: {},
            success: function (e) {
                console.log(e), $("#locate").css({
                    background: "url(icon/i_location.png) no-repeat right center"
                }), 0 != e ? location = e : alert("定位失败!")
            },
            error: function (e) {
                console.log(e)
            }
        });
    }, {
        timeout: 3e3
    }) : console.log("navigator not work")
}

$(function () {

    $("#locate").on("click", getPosition);
    var t = "";
    $(".search_default b").on("click", function () {
        $(".search_default em").width() ? t = $(".search_default em").width() : "", $(".search_default em").animate({
            paddingLeft: "0px",
            width: "0px"
        }, 500), $("#search .search_default input").animate({
            width: "370px",
            opacity: "1"
        }, 500), $("#search .search_default i").animate({
            width: "20px",
            marginRight: "10px",
            opacity: "1"
        }), $("#search .search_default input").focus()
    }), $(".search_default input").on("keyup", function () {
        $(".search_city").show(), getCitys($(this).val())
    }), $("#search .search_default i").on("click", function () {
        $(this).animate({
            width: "0px",
            marginRight: "0px"
        }, 500), $(".search_default em").animate({
            paddingLeft: "30px",
            width: t
        }, 500), $("#search .search_default input").animate({
            width: "0",
            opacity: "0"
        }, 500), $("#search .search_default i").animate({
            opacity: "0"
        }), $("#search .search_default input").val(""), $(".search_city").hide()
    }), $("#search .search_city li").on("click", function () {
        $(".search_input").hide(), $(".search_default").show().text($(this).text()), $("#search .search_input input").val(""), $(".search_city").hide()
    });

});

var showCity = function (e) {
    var t = e.coords.longitude,
        a = e.coords.latitude;
    return void 0 != t && void $.ajax({
            url: "geolocate/" + t + "/" + a,
            data: {},
            success: function (e) {
                $("#locate").css({
                    background: "url(icon/i_locate.png) no-repeat right center"
                }), 0 != e && (location = e)
            },
            error: function (e) {
                console.log(e)
            }
        })
};