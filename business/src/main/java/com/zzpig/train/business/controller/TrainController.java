package com.zzpig.train.business.controller;

import com.zzpig.train.business.service.TrainSeatService;
import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
//import com.zzpig.train.business.req.MemberRegisterReq;
import com.zzpig.train.business.req.TrainQueryReq;
import com.zzpig.train.business.req.TrainSaveReq;
import com.zzpig.train.business.resp.TrainQueryResp;
import com.zzpig.train.business.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @Autowired
    TrainSeatService trainSeatService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody TrainSaveReq req){
        trainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainQueryResp>> queryList(@Valid TrainQueryReq req){
        PageResp<TrainQueryResp> list = trainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        trainService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryAll(){
        List<TrainQueryResp> list = trainService.queryAll();
        return new CommonResp<>(list);
    }

    @GetMapping("/gen-seat/{trainCode}")
    public CommonResp<Object> genSeat(@PathVariable String trainCode){
        trainSeatService.genTrainSeat(trainCode);
        return new CommonResp<>();
    }


}
