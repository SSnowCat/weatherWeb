package com.snow.weather.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/23.
 */
public class SecondScheduledJob extends QuartzJobBean{

    private GetDataByHalfMonth getDataByHalfMonth;

    public void setGetDataByHalfMonth(GetDataByHalfMonth getDataByHalfMonth) {
        this.getDataByHalfMonth = getDataByHalfMonth;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("SecondScheduledJon Executes!"+sdf.format(date));
        this.getDataByHalfMonth.getDataByHalfMonth();
    }
}
