package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.DailyTrainQueryReq;
import com.zzpig.train.business.req.DailyTrainSaveReq;
import com.zzpig.train.business.resp.DailyTrainQueryResp;
import com.zzpig.train.business.service.DailyTrainService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {
    private static final Logger LOG = LoggerFactory.getLogger(DailyTrainAdminController.class);

    @Autowired
    DailyTrainService dailyTrainService;


    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody DailyTrainSaveReq req){
    dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req){
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/gen-daily/{date}")
    public CommonResp<Object> delete(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        dailyTrainService.genDaily(date);
        return new CommonResp<>();
    }

}
