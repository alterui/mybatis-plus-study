package com.lr.web.bean;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liurui
 * @date 2020/4/3 11:15 上午
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentVO  extends Student{
    private String name;
    private Integer tel;

    public StudentVO() {
        this.tel = 0;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                ", tel=" + tel +
                ", age=" + getAge() +
                '}';
    }
}
