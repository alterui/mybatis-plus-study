package com.lr.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lr.mp.bean.User;
import com.lr.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusStudyApplicationTests {


    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        User user = userMapper.selectById(1L);
        System.out.println(user);

    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Tom").eq("id", 3L);
        User user = userMapper.selectOne(wrapper);

        System.out.println(user);

    }

    @Test
    public void testSelectBatchIds() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);

        List<User> users = userMapper.selectBatchIds(ids);

        System.out.println(users);

    }

    @Test
    public void testSelectByMap() {

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "tom");
        columnMap.put("age", 28);
        List<User> users = userMapper.selectByMap(columnMap);

        System.out.println(users);

    }


    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(24);

        user.setEmail("323@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);

        Long key = user.getId();
        System.out.println("key:" + key);

    }

    @Test
    public void updateInsert() {
        User user = new User();
        user.setId(9L);
        user.setName("wL");
        user.setAge(21);
        user.setEmail("32@qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);

    }

    @Test
    public void updateInsertMapper() {
        User user = new User();
        user.setId(9L);
        user.setName("wangbadan");

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("name", "wL");
        int i = userMapper.update(user, wrapper);
        System.out.println(i);

    }


    @Test
    public void testSelectByPage() {


        Page<User> page = new Page<>(1, 2);//参数一是当前页，参数二是每页个数
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> list = userIPage.getRecords();
        list.forEach(System.out::println);

    }


    @Test
    public void testSelectByWrapper() {
        QueryWrapper<User> query = Wrappers.query();
        query.nested(e -> e.eq("name", "Tom").or().eq("age", 20));

        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);

    }


    /**
     * 过滤不需要展示的列
     */
    @Test
    public void testSelectByWrapper1() {
        QueryWrapper<User> query = Wrappers.query();
        query.select(User.class, e -> !e.getColumn().equals("age"));
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);

    }


    @Test
    public void testSelectByWrapper2() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    public void testSelectByWrapper3() {
        QueryWrapper<User> query = Wrappers.query();
        query.select("name", "age");
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);

    }

    @Test
    public void testSelectByWrapper4() {
        condition("Tom", null);
    }

    private void condition(String name, String age) {
        QueryWrapper<User> query = Wrappers.query();
        query.eq(!StringUtils.isEmpty(name), "name", name).eq(!StringUtils.isEmpty(age), "age", age);
        List<User> users = userMapper.selectList(query);
        users.forEach(System.out::println);

    }


    @Test
    public void testSelectByWrapper5() {
        User user = new User();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }


}
