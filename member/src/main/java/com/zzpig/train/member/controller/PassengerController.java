package com.zzpig.train.member.controller;

import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.member.req.MemberRegisterReq;
import com.zzpig.train.member.req.PassengerSaveReq;
import com.zzpig.train.member.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody PassengerSaveReq req){
        passengerService.save(req);
        return new CommonResp<>();
    }
}
