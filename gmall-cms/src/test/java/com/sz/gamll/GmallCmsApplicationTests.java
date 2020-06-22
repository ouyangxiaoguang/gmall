package com.sz.gamll;

import com.sz.gmall.cms.entity.PrefrenceArea;
import com.sz.gmall.cms.entity.Subject;
import com.sz.gmall.cms.entity.Topic;
import com.sz.gmall.cms.service.PrefrenceAreaService;
import com.sz.gmall.cms.service.SubjectService;
import com.sz.gmall.cms.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallCmsApplicationTests {

    @Autowired
    TopicService topicService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    PrefrenceAreaService prefrenceAreaService;

    @Test
    public void test() {
        Topic topic = new Topic();
        topic.setName("AAAA");
        topicService.save(topic);
        System.out.println("成功了");
    }

    @Test
    public void test_listAll() {

        List<Subject> sublist = subjectService.findListByAll();
        System.out.println(sublist.size());
        List<PrefrenceArea> prefrenceAreas = prefrenceAreaService.findListByAll();
        System.out.println(prefrenceAreas.size());
    }

}
