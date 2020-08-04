package com.hjc.sharding.demo;

import com.hjc.sharding.demo.entity.Member;
import com.hjc.sharding.demo.service.MemberService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcDemoApplicationTests {


    @Autowired
    private MemberService memberService;

	@Test
	public void contextLoads() {
	}

	public void transactionTest1(){
        Member member = new Member();
        member.setName("transaction_1");
        member.setMobile("123123");

        System.out.println(memberService.saveAndGet(member).getName());

    }

}
