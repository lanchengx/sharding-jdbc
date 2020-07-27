package com.hjc.sharding.demo.controller;

import com.hjc.sharding.demo.entity.Member;
import com.hjc.sharding.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("save")
    public String save(@RequestBody Member member) {
        memberService.save(member);
        return "ok";
    }

    @GetMapping("selectById")
    public Member selectById(String id) {
        return memberService.getById(id);
    }
}
