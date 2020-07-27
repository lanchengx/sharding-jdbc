package com.hjc.sharding.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjc.sharding.demo.entity.Member;
import com.hjc.sharding.demo.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberService extends ServiceImpl<MemberMapper, Member> {

    @Transactional(rollbackFor = Exception.class)
    public boolean mySave(Member member) {
        saveOrUpdate(member);
        return true;
    }
}