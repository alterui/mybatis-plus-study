package com.lr.web.controller;

import com.alibaba.fastjson.JSON;
import com.lr.web.bean.Student;
import com.lr.web.bean.StudentVO;
import com.lr.web.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2020/4/3 11:16 上午
 */
@RestController
@Slf4j
public class IndexController {

    @PostMapping("/get")
    public Student get(@RequestBody Student student) {
        System.out.println(student.getAge());
        System.out.println(student.getTel());

        return student;

    }


    @GetMapping("/get1")
    public List<StudentVO> get1() {

        List<Student> studentList = new ArrayList<>();
        List<StudentVO> studentVOList = new ArrayList<>();

        studentList.forEach(e -> {
            StudentVO studentVO = new StudentVO();
            studentVO.setAge(e.getAge());
            studentVO.setName("");
            studentVOList.add(studentVO);

        });
        return studentVOList;
    }

}
