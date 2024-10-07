package com.zzpig.train.member.controller;

import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.member.req.MemberRegisterReq;
import com.zzpig.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count(){
        // 每个人都是这样，享受过提心吊胆，才拒绝做爱情待罪的羔羊。
        int count = memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(count);
        return commonResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req){
        long register = memberService.register(req);
//        CommonResp<Long> commonResp = new CommonResp<>();
//        commonResp.setContent(register);
//        return commonResp;
        return new CommonResp<>(register);
    }

}
