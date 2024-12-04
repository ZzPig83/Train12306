package com.zzpig.train.business.controller;

import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
//import com.zzpig.train.business.req.MemberRegisterReq;
import com.zzpig.train.business.req.DailyTrainTicketQueryReq;
import com.zzpig.train.business.req.DailyTrainTicketSaveReq;
import com.zzpig.train.business.resp.DailyTrainTicketQueryResp;
import com.zzpig.train.business.service.DailyTrainTicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/daily-train-ticket")
public class DailyTrainTicketController {

    @Autowired
    DailyTrainTicketService dailyTrainTicketService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody DailyTrainTicketSaveReq req){
    dailyTrainTicketService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req){
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        dailyTrainTicketService.delete(id);
        return new CommonResp<>();
    }
}
