package com.sz.gmall;

import com.sz.gmall.pms.entity.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("hello", "world");
        System.out.println("保存了数据");
        String hello = stringRedisTemplate.opsForValue().get("hello");
        System.out.println(hello);
    }
    @Test
    public void test1() {
        Brand b = new Brand();
        b.setBigPic("sasa");
       redisTemplate.opsForValue().set("Brand",b);
        System.out.println("保存了数据");
        Object brand = redisTemplate.opsForValue().get("Brand");
        System.out.println(brand);
    }
}
