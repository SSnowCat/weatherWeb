package com.snow.weather.vo;

/**
 * Created by 李德阳 on 2017/6/23.
 */
public class LiveIndexVO {
    private String name;
    private String icon;
    private String desc;
    private String status;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
        switch (name) {
            case "化妆":
                this.icon = "7";
                break;
            case "感冒":
                this.icon = "12";
                break;
            case "洗车":
                this.icon = "17";
                break;
            case "空气污染":
                this.icon = "0";
                break;
            case "穿衣":
                this.icon = "20";
                break;
            case "紫外线":
                this.icon = "21";
                break;
            case "运动":
                this.icon = "26";
                break;
            case "钓鱼":
                this.icon = "28";
                break;
            default:
                this.icon = "21";
                break;
        }
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
