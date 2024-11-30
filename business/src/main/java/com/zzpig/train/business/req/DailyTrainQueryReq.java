package com.zzpig.train.business.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zzpig.train.common.req.PageReq;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DailyTrainQueryReq extends PageReq {

    private String code;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TrainStationQueryReq{" +
                "code='" + code + '\'' +
                "date='" + date + '\'' +
                "} " + super.toString();
    }
}
