package com.zzpig.train.member.controller.feign;

import com.zzpig.train.common.req.MemberTicketReq;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.member.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/ticket")
public class FeignTicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/save")
    public CommonResp<Object> save(@RequestBody MemberTicketReq req) throws Exception{
        ticketService.save(req);
        return new CommonResp<>();
    }
}
