package com.zzpig.train.business.controller;

import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
//import com.zzpig.train.business.req.MemberRegisterReq;
import com.zzpig.train.business.req.StationQueryReq;
import com.zzpig.train.business.req.StationSaveReq;
import com.zzpig.train.business.resp.StationQueryResp;
import com.zzpig.train.business.service.StationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/station")
public class StationController {

    @Autowired
    StationService stationService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody StationSaveReq req){
    stationService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req){
        PageResp<StationQueryResp> list = stationService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        stationService.delete(id);
        return new CommonResp<>();
    }

    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResp>> queryAll(){
        List<StationQueryResp> list = stationService.queryAll();
        return new CommonResp<>(list);
    }
}
