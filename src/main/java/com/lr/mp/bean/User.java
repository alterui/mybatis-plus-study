package com.lr.mp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liurui
 * @date 2020/3/21 10:00
 */
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private String email;
}
