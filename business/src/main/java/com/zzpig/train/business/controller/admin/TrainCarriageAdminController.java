package com.zzpig.train.business.controller.admin;

import com.zzpig.train.business.req.TrainCarriageQueryReq;
import com.zzpig.train.business.req.TrainCarriageSaveReq;
import com.zzpig.train.business.resp.TrainCarriageQueryResp;
import com.zzpig.train.business.service.TrainCarriageService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-carriage")
public class TrainCarriageAdminController {

    @Autowired
    TrainCarriageService trainCarriageService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody TrainCarriageSaveReq req){
    trainCarriageService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainCarriageQueryResp>> queryList(@Valid TrainCarriageQueryReq req){
        PageResp<TrainCarriageQueryResp> list = trainCarriageService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        trainCarriageService.delete(id);
        return new CommonResp<>();
    }
}
