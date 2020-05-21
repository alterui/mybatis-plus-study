package com.lr.web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liurui
 * @date 2020/4/3 11:14 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String age;
    private String tel;

    public Student(String age) {
        this.age = age;
    }


}
