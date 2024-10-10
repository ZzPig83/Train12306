package com.zzpig.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.zzpig.train.common.exception.BusinessException;
import com.zzpig.train.common.exception.BusinessExceptionEnum;
import com.zzpig.train.common.util.SnowUtil;
import com.zzpig.train.member.domain.Member;
import com.zzpig.train.member.domain.MemberExample;
import com.zzpig.train.member.mapper.MemberMapper;
import com.zzpig.train.member.req.MemberLoginReq;
import com.zzpig.train.member.req.MemberRegisterReq;
import com.zzpig.train.member.req.MemberSendCodeReq;
import com.zzpig.train.member.resp.MemberLoginResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        Member memberDB = selectMember(mobile);
        if(ObjectUtil.isNotNull(memberDB)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
//        member.setId(System.currentTimeMillis());
//        member.setId(1728304023362L);
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);

        memberMapper.insert(member);
        return member.getId();
    }

    public void sendCode(MemberSendCodeReq req){
        String mobile = req.getMobile();
        Member memberDB = selectMember(mobile);
        // 如果手机号不存在，则插入一条记录
        if(ObjectUtil.isNull(memberDB)){
            LOG.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }else{
            LOG.info("手机号存在，不插入记录");
        }
        // 生成验证码
        String code = RandomUtil.randomString(4);
        LOG.info("生成验证码：{}",code);
        // 保存短信记录表: 手机号，验证码，有效期，是否已使用，业务类型，发送时间，使用时间
    }

    public MemberLoginResp login(MemberLoginReq req){
        String mobile = req.getMobile();
        String code = req.getCode();
        Member memberDB = selectMember(mobile);
        // 如果手机号不存在，则报异常
        if(ObjectUtil.isNull(memberDB)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        // 校验验证码
        if(!"8888".equals(code)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_WRONG);
        }
        MemberLoginResp memberLoginResp = BeanUtil.copyProperties(memberDB, MemberLoginResp.class);
        return memberLoginResp;
    }

    private Member selectMember(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if(CollUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
    }

}
