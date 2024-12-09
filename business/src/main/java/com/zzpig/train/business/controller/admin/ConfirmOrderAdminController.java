package com.zzpig.train.business.controller.admin;

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
@RequestMapping("/admin/confirm-order")
public class ConfirmOrderAdminController {

    @Autowired
    ConfirmOrderService confirmOrderService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody ConfirmOrderDoReq req){
    confirmOrderService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<ConfirmOrderQueryResp>> queryList(@Valid ConfirmOrderQueryReq req){
//        req.setMemberId(LoginMemberContext.getId());
        PageResp<ConfirmOrderQueryResp> list = confirmOrderService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        confirmOrderService.delete(id);
        return new CommonResp<>();
    }
}
