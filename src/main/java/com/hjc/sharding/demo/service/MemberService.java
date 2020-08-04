package com.hjc.sharding.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjc.sharding.demo.entity.Member;
import com.hjc.sharding.demo.mapper.MemberMapper;
import io.shardingsphere.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberService extends ServiceImpl<MemberMapper, Member> {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean mySave(Member member) {
        saveOrUpdate(member);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public Member saveAndGet(Member member) {
        save(member);
        return getById(member.getId());
    }
    @Transactional(rollbackFor = Exception.class)
    public void getBy() {
        System.out.println("getBy() "+Thread.currentThread().getName());

        Member member = getById(1);
        System.out.println("get: " + member.getName());
    }
    @Transactional(rollbackFor = Exception.class)
    public String GetAndSave(Member member) {
        getBy();
        System.out.println("GetAndSave"+Thread.currentThread().getName());
        Member temp = getById(1);
        member.setName(temp.getName());
        save(member);
        return member.getName();
    }

    public void listAll() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        List<Member> list = memberMapper.getBy();
        System.out.println(list.size());

    }


}