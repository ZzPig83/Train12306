package com.zzpig.train.business.controller;

import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
//import com.zzpig.train.business.req.MemberRegisterReq;
import com.zzpig.train.business.req.SkTokenQueryReq;
import com.zzpig.train.business.req.SkTokenSaveReq;
import com.zzpig.train.business.resp.SkTokenQueryResp;
import com.zzpig.train.business.service.SkTokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/sk-token")
public class SkTokenController {

    @Autowired
    SkTokenService skTokenService;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody SkTokenSaveReq req){
    skTokenService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<SkTokenQueryResp>> queryList(@Valid SkTokenQueryReq req){
//        req.setMemberId(LoginMemberContext.getId());
        PageResp<SkTokenQueryResp> list = skTokenService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        skTokenService.delete(id);
        return new CommonResp<>();
    }
}
