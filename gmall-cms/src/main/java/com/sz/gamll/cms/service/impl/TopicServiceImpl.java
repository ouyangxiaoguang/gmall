package com.sz.gamll.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.gamll.cms.mapper.TopicMapper;
import com.sz.gmall.cms.entity.Topic;
import com.sz.gmall.cms.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 话题表 服务实现类
 * </p>
 *
 * @author GG
 * @since 2020-06-11
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {

}
