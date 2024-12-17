package com.zzpig.train.business.req;

import com.zzpig.train.common.req.PageReq;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class DailyTrainTicketQueryReq extends PageReq {
    private String trainCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String start;

    private String end;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyTrainTicketQueryReq that = (DailyTrainTicketQueryReq) o;
        return Objects.equals(trainCode, that.trainCode) && Objects.equals(date, that.date) && Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainCode, date, start, end);
    }

    @Override
    public String toString() {
        return "DailyTrainTicketQueryReq{" +
                "} " + super.toString();
    }
}
