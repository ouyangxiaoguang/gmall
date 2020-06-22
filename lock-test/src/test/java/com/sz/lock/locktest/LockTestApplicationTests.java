package com.sz.lock.locktest;

import com.sz.lock.locktest.utils.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LockTestApplicationTests {
    @Autowired
    private JedisUtil jedisUtil;

    @Test
    public void contextLoads() {

        jedisUtil.set("A","AAAA");
        System.out.println("成功");
    }

}
