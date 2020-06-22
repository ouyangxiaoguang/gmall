package com.sz.mq.mqtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqTestApplicationTests {

    @Test
    public void contextLoads() {

        Map<String,String> map = new HashMap<>();

        map.put("16","D");

        for (String str:map.keySet()) {
            System.out.println(str);
        }
        System.out.println("-------------------------------------------------");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
        }
    }


    @Test
    public void test(){

    }

}
