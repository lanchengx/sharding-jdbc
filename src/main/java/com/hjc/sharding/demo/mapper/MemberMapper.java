package com.hjc.sharding.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjc.sharding.demo.entity.Member;

import java.util.List;


public interface MemberMapper extends BaseMapper<Member> {


    List<Member> getBy();
}
