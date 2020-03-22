package com.lr.mp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liurui
 * @date 2020/3/21 10:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private Integer age;
    private String name;

    private String email;
}
