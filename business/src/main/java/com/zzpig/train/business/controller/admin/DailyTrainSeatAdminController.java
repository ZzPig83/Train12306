package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.DailyTrainSeatQueryReq;
import com.zzpig.train.business.req.DailyTrainSeatSaveReq;
import com.zzpig.train.business.resp.DailyTrainSeatQueryResp;
import com.zzpig.train.business.service.DailyTrainSeatService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-seat")
public class DailyTrainSeatAdminController {

    @Autowired
    DailyTrainSeatService dailyTrainSeatService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody DailyTrainSeatSaveReq req){
    dailyTrainSeatService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainSeatQueryResp>> queryList(@Valid DailyTrainSeatQueryReq req){
        PageResp<DailyTrainSeatQueryResp> list = dailyTrainSeatService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        dailyTrainSeatService.delete(id);
        return new CommonResp<>();
    }
}
