package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.TrainStationQueryReq;
import com.zzpig.train.business.req.TrainStationSaveReq;
import com.zzpig.train.business.resp.TrainStationQueryResp;
import com.zzpig.train.business.service.TrainStationService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-station")
public class TrainStationAdminController {

    @Autowired
    TrainStationService trainStationService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody TrainStationSaveReq req){
    trainStationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainStationQueryResp>> queryList(@Valid TrainStationQueryReq req){
        PageResp<TrainStationQueryResp> list = trainStationService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        trainStationService.delete(id);
        return new CommonResp<>();
    }
}
