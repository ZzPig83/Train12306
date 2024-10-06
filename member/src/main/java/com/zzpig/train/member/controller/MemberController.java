package com.zzpig.train.member.controller;

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
    public int count(){
        // 每个人都是这样，享受过提心吊胆，才拒绝做爱情待罪的羔羊。
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(String mobile){
        return memberService.register(mobile);
    }

}
