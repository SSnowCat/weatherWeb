$(document).ready(function () {
    var t = {
        ul: $(".detail_future_grid .wea_list ul"),
        prev: $(".detail_future_grid .prev"),
        next: $(".detail_future_grid .next"),
        li: $(".detail_future_grid .wea_list ul li")
    }, e = {high: -1e4, low: 1e4, unit: ""}, i = 70 * t.ul.find("li").length;
    t.ul.css("width", i);
    for (var a = 2, n = 70, r = 0; r < t.li.length; r++) {
        var o = parseInt(t.li.eq(r).find(".tree b").text()), s = parseInt(t.li.eq(r).find(".tree strong").text());
        e.high = e.high > o ? e.high : o, e.low = e.low < s ? e.low : s
    }
    e.unit = 112 / (e.high - e.low);
    for (var r = 0; r < t.li.length; r++) {
        var c = t.li.eq(r), o = parseInt(c.find(".tree b").text()), u = (e.high - o) / 2 * e.unit,
            s = parseInt(c.find(".tree strong").text()), l = (s - e.low) / 2 * e.unit, h = c.find(".wea"),
            d = h.text().length;
        d > 2 && d <= 6 ? h.css("fontSize", "12px") : d > 6 && (h.css("fontSize", "12px"), h.text(h.text().slice(0, 3) + "...")), c.find("p").css({
            top: u,
            bottom: l
        })
    }
    var g = $(".detail_future_grid .wea_list ul").css("marginLeft");
    "0" == parseInt(g) && $(".detail_future_grid .prev").hide(), $(".detail_future_grid .prev").on("click", function () {
        var t = 0;
        $(".detail_future_grid .next").show();
        var e = parseInt($(".detail_future_grid .wea_list ul").css("marginLeft"));
        e >= 0 - a * n ? (t = 0, $(this).hide()) : (t = e + a * n, $(this).show()), $(".detail_future_grid .wea_list ul").animate({marginLeft: t}, 500)
    }), $(".detail_future_grid .next").on("click", function () {
        var t = 0;
        $(".detail_future_grid .prev").show();
        var e = parseInt($(".detail_future_grid .wea_list ul").css("marginLeft"));
        e <= 680 - i + 20 + a * n ? (t = 680 - i + 20, $(this).hide()) : (t = e - a * n, $(this).show()), $(".detail_future_grid .wea_list ul").animate({marginLeft: t}, 500)
    });

});
