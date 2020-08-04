package com.hjc.sharding.demo.controller;

import com.hjc.sharding.demo.entity.Member;
import com.hjc.sharding.demo.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("member")
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(MemberController.class);
    @Autowired
    private MemberService memberService;

    @PostMapping("save")
    public String save(@RequestBody Member member) {
        memberService.save(member);
        return "ok";
    }

    @PostMapping("saveAndReturn")
    public String saveAndReturn(@RequestBody Member member) {
        Member result = memberService.saveAndGet(member);
        logger.info("return Name is  {}", result.getName());
        return "ok";
    }

    @PostMapping("getAndSave")
    public String getAndSave(@RequestBody Member member) {
        String result = memberService.GetAndSave(member);
        logger.info("return member is  {}", result);
        return "ok";
    }
    @PostMapping("list")
    public String list() {
        memberService.listAll();
        return "ok";
    }


    @GetMapping("selectById")
    public Member selectById(String id) {
        return memberService.getById(id);
    }
}
