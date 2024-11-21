package com.zzpig.train.${module}.controller;

import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.resp.CommonResp;
import com.zzpig.train.common.resp.PageResp;
import com.zzpig.train.${module}.req.MemberRegisterReq;
import com.zzpig.train.${module}.req.${Domain}QueryReq;
import com.zzpig.train.${module}.req.${Domain}SaveReq;
import com.zzpig.train.${module}.resp.${Domain}QueryResp;
import com.zzpig.train.${module}.service.${Domain}Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${domain}")
public class ${Domain}Controller {

    @Autowired
    ${Domain}Service ${domain}Service;

    @PostMapping("/save")
    public CommonResp<Long> save(@Valid @RequestBody ${Domain}SaveReq req){
    ${domain}Service.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<${Domain}QueryResp>> queryList(@Valid ${Domain}QueryReq req){
        req.setMemberId(LoginMemberContext.getId());
        PageResp<${Domain}QueryResp> list = ${domain}Service.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id){
        ${domain}Service.delete(id);
        return new CommonResp<>();
    }
}
