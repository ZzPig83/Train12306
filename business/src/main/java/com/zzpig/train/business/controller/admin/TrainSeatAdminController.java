package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.TrainSeatQueryReq;
import com.zzpig.train.business.req.TrainSeatSaveReq;
import com.zzpig.train.business.resp.TrainSeatQueryResp;
import com.zzpig.train.business.service.TrainSeatService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-seat")
public class TrainSeatAdminController {

    @Autowired
    TrainSeatService trainSeatService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody TrainSeatSaveReq req){
    trainSeatService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainSeatQueryResp>> queryList(@Valid TrainSeatQueryReq req){
        PageResp<TrainSeatQueryResp> list = trainSeatService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        trainSeatService.delete(id);
        return new CommonResp<>();
    }
}
