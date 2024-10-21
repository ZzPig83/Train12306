package com.zzpig.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.zzpig.train.common.context.LoginMemberContext;
import com.zzpig.train.common.exception.BusinessException;
import com.zzpig.train.common.exception.BusinessExceptionEnum;
import com.zzpig.train.common.util.SnowUtil;
import com.zzpig.train.member.domain.Member;
import com.zzpig.train.member.domain.Passenger;
import com.zzpig.train.member.domain.PassengerExample;
import com.zzpig.train.member.mapper.PassengerMapper;
import com.zzpig.train.member.req.PassengerQueryReq;
import com.zzpig.train.member.req.PassengerSaveReq;
import com.zzpig.train.member.resp.PassengerQueryResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req){
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setMemberId(LoginMemberContext.getId());
        LOG.info("会员memberId是{}",LoginMemberContext.getId());
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

    public List<PassengerQueryResp> queryList(PassengerQueryReq req){
        PassengerExample passengerExample = new PassengerExample();
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if(ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        PageHelper.startPage(1,2);
        List<Passenger> passengerList = passengerMapper.selectByExample(passengerExample);
        return BeanUtil.copyToList(passengerList, PassengerQueryResp.class);
    }
}
