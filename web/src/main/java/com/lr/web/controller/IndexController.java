package com.lr.web.controller;

import com.alibaba.fastjson.JSON;
import com.lr.web.bean.Student;
import com.lr.web.bean.StudentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liurui
 * @date 2020/4/3 11:16 上午
 */
@RestController
public class IndexController {

    @GetMapping("/get")
    public List<StudentVO> get() {

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student(12);
        Student student2 = new Student(14);

        studentList.add(student1);
        studentList.add(student2);

        List<StudentVO> studentVOList = new ArrayList<>();

        studentList.forEach(e->{
            StudentVO studentVO = JSON.parseObject(JSON.toJSONString(e), StudentVO.class);
            studentVOList.add(studentVO);
        });


        return studentVOList;

    }

}
