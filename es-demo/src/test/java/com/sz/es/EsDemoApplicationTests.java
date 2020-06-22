package com.sz.es;



import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDemoApplicationTests {
    @Autowired
    private JestClient jestClient;

    @Test
    public void contextLoads() {

        System.out.println(jestClient);
    }

    @Test
    public void index() throws IOException {

        User user = new User();
        user.setUserName("张飒");
        user.setEmail("233423@163.com");

        Index builder = new Index.Builder(user)
                .index("user")
                .type("info")
                .build();
        DocumentResult execute = jestClient.execute(builder);
        System.out.println(execute.getId()+">>>>"+execute.isSucceeded());

    }
    @Test
    public void test1() {
//        String str ="a,b,c,d,e";
//        String[] split = str.split(",");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }



    }
}

class User {
    private String userName;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
