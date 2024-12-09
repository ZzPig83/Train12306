package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.DailyTrainStationQueryReq;
import com.zzpig.train.business.req.DailyTrainStationSaveReq;
import com.zzpig.train.business.resp.DailyTrainStationQueryResp;
import com.zzpig.train.business.service.DailyTrainStationService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-station")
public class DailyTrainStationAdminController {

    @Autowired
    DailyTrainStationService dailyTrainStationService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody DailyTrainStationSaveReq req){
    dailyTrainStationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainStationQueryResp>> queryList(@Valid DailyTrainStationQueryReq req){
        PageResp<DailyTrainStationQueryResp> list = dailyTrainStationService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        dailyTrainStationService.delete(id);
        return new CommonResp<>();
    }
}
