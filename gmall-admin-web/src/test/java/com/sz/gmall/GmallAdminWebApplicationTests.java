package com.sz.gmall;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sz.gmall.pms.service.ProductAttributeService;
import com.sz.gmall.ums.controller.UmsAdminController;
import com.sz.gmall.vo.PageInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallAdminWebApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(GmallAdminWebApplicationTests.class);
    @Reference
    private ProductAttributeService productAttributeService;

    // @Test
    public void contextLoads() {

        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
        logger.debug("sahjhsja{}", "ABC");
        logger.info("AAAAAAA{},ddddd{}", "ABC", "CCCC");
    }


    @Test
    public void productAttributeServiceByGetProductAttributeCidAndTypePages() {
        PageInfoVO page = productAttributeService.getProductAttributeCidAndTypePages((long) 1, 0, 1, 5);
        System.out.println(page.getList().size());
    }

}
