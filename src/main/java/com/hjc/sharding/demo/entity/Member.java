package com.hjc.sharding.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("member")
public class Member {

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    private String name;

    private String mobile;
}
