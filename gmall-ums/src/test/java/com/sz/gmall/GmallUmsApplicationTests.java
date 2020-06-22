package com.sz.gmall;

import com.sz.gmall.ums.entity.Admin;
import com.sz.gmall.ums.entity.MemberLevel;
import com.sz.gmall.ums.service.AdminService;
import com.sz.gmall.ums.service.MemberLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUmsApplicationTests {
    @Autowired
    AdminService adminService;

    @Autowired
    MemberLevelService memberLevelService;

    @Test
    public void test(){
        Admin byId = adminService.getById(1);
        System.out.println(byId);
    }
    @Test
    public void testReadOnWrite(){
        /*测试读写分离*/
//        Admin admin = new Admin();
//        admin.setId(3L);
//        admin.setNickName("ahhhh/");
        Admin byId = adminService.getById(4);

        System.err.println(byId.getNickName());

    }

    @Test
    public void test_memberLevel_list(){


        List<MemberLevel> listByDefaultStatus = memberLevelService.findListByDefaultStatus(0);
        System.out.println(listByDefaultStatus.size());

    }


}
