package com.zzpig.train.business.controller;

import com.zzpig.train.business.req.ConfirmOrderDoReq;
import com.zzpig.train.business.req.ConfirmOrderQueryReq;
import com.zzpig.train.business.resp.ConfirmOrderQueryResp;
import com.zzpig.train.business.service.ConfirmOrderService;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    @Autowired
    ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    public CommonResp<Long> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req){
    confirmOrderService.doConfirm(req);
        return new CommonResp<>();
    }

}
