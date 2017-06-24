package com.snow.weather.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/22.
 */
public class FirstScheduledJob extends QuartzJobBean{

    private GetDataByDay getDataByDay;

    public void setGetDataByDay(GetDataByDay getDataByDay) {
        this.getDataByDay = getDataByDay;
    }

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("FirstScheduledJon Executes!"+sdf.format(date));
        this.getDataByDay.getDataByDay();
    }


}
