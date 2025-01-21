package com.zzpig.train.business.mapper.cust;

import com.zzpig.train.business.domain.SkToken;
import com.zzpig.train.business.domain.SkTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SkTokenMapperCust {

    int decrease(Date date, String trainCode, int decreaseCount);

}